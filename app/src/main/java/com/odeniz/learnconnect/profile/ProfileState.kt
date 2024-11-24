package com.odeniz.learnconnect.profile

import com.odeniz.learnconnect.entity.User

sealed class ProfileState {
    data object Loading : ProfileState()
    data class Success(val user: User) : ProfileState()
    data object SuccessUpdate : ProfileState()
    data class Error(val message: String) : ProfileState()
}