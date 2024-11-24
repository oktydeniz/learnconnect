package com.odeniz.learnconnect.auth

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.User
import com.odeniz.learnconnect.entity.dao.UserDao
import com.odeniz.learnconnect.local.DataStoreManager
import com.odeniz.learnconnect.model.UserDto
import com.odeniz.learnconnect.util.VerifyFields
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val dataSource: DataStoreManager,
    private val userDao: UserDao,
    private val resources: Resources
) : ViewModel() {

    private val _registerState = MutableLiveData<UserState>()
    val registerState: LiveData<UserState> get() = _registerState

    fun insertUser(user: UserDto) {
        if (!isVerifiedModel(user)) {
            return
        }
        viewModelScope.launch {
            _registerState.value = UserState.Loading
            val current = User(
                fullName = user.fullName,
                email = user.email,
                password = user.password,
                about = "",
                profileImage = null
            )
            val count = userDao.isMailExist(user.email).first()
            if (count > 0) {
                _registerState.value =
                    UserState.Error(resources.getString(R.string.mail_already_exist))
            } else {
                viewModelScope.launch {
                    try {
                        withContext(Dispatchers.IO) {
                            userDao.insertUser(current)
                            saveLoginStatus(current)
                        }
                        _registerState.value = UserState.Success
                    } catch (e: Exception) {
                        _registerState.value =
                            UserState.Error(resources.getString(R.string.failed_to_register_user))
                    }
                }
            }
        }
    }

    private suspend fun saveLoginStatus(user: User) {
        dataSource.saveLoginStatus(true)
        val result = userDao.getUserByMail(user.email).first()
        result.let { u ->
            dataSource.saveUserInfo(u)
        }
    }

    private fun isVerifiedModel(user: UserDto): Boolean {
        if (!VerifyFields.isValidUsername(user.fullName)) {
            _registerState.value =
                UserState.Error(resources.getString(R.string.username_is_not_valid_please_check_again))
            return false
        }
        if (!VerifyFields.isValidEmail(user.email)) {
            _registerState.value =
                UserState.Error(resources.getString(R.string.email_is_not_valid_please_check_again))
            return false
        }
        if (!VerifyFields.isValidPassword(user.password)) {
            _registerState.value =
                UserState.Error(resources.getString(R.string.password_length_should_be_at_least_6_please_check_again))
            return false
        }
        if (!VerifyFields.doPasswordsMatch(user.password, user.passwordVerify)) {
            _registerState.value =
                UserState.Error(resources.getString(R.string.passwords_do_not_match_please_check_again))
            return false
        }
        return true
    }
}