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
import com.odeniz.learnconnect.util.VerifyFields
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataSource: DataStoreManager,
    private val userDao: UserDao,
    private val resources: Resources
) : ViewModel() {

    private val _loginState = MutableLiveData<UserState>()
    val loginState: LiveData<UserState> get() = _loginState

    fun login(email: String, password: String) {
        if (!isVerifiedModel(email, password)) {
            return
        }
        viewModelScope.launch {
            _loginState.value = UserState.Loading
            try {
                withContext(Dispatchers.IO) {
                    val user = userDao.getUser(email, password).first()
                    user?.let {
                        saveLoginStatus(it)
                    }
                }
                _loginState.value = UserState.Success
            } catch (e: Exception) {
                _loginState.value =
                    UserState.Error(resources.getString(R.string.failed_to_register_user))
            }
        }
    }

    private suspend fun saveLoginStatus(user: User) {
        dataSource.saveLoginStatus(true)
        dataSource.saveUserInfo(user)
    }

    private fun isVerifiedModel(email: String, password: String): Boolean {

        if (!VerifyFields.isValidEmail(email)) {
            _loginState.value =
                UserState.Error(resources.getString(R.string.email_is_not_valid_please_check_again))
            return false
        }
        if (!VerifyFields.isValidPassword(password)) {
            _loginState.value =
                UserState.Error(resources.getString(R.string.password_length_should_be_at_least_6_please_check_again))
            return false
        }
        return true
    }
}