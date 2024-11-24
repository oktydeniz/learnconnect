package com.odeniz.learnconnect.profile

import android.content.res.Resources
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.dao.UserDao
import com.odeniz.learnconnect.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataSource: DataStoreManager,
    private val userDao: UserDao,
    private val resources: Resources,
) : ViewModel() {

    private val _profileState = MutableLiveData<ProfileState>()
    val profileState: LiveData<ProfileState> get() = _profileState

    private suspend fun getUserId() = dataSource.userInfo.first().id
    fun profile() {
        viewModelScope.launch {
            _profileState.value = ProfileState.Loading
            try {
                val user = userDao.getUserById(getUserId()).first()
                _profileState.value = ProfileState.Success(user)
            } catch (e: Exception) {
                _profileState.value =
                    ProfileState.Error(resources.getString(R.string.unknown_error))
            }
        }
    }

    fun updateProfile(userName: String, mail: String, about: String, selectedUri: Bitmap?) {
        viewModelScope.launch {
            _profileState.value = ProfileState.Loading
            withContext(Dispatchers.IO) {
                try {
                    selectedUri?.let {
                        userDao.updateProfileWithImage(getUserId(), userName, mail, about, it)
                    } ?: run {
                        userDao.updateProfile(getUserId(), userName, mail, about)
                    }
                    withContext(Dispatchers.Main) {
                        _profileState.value = ProfileState.SuccessUpdate
                    }
                } catch (e: Exception) {
                    _profileState.value = e.localizedMessage?.let { ProfileState.Error(it) }
                }
            }
        }
    }

}