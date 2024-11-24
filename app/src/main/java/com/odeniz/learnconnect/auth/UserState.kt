package com.odeniz.learnconnect.auth

sealed class UserState {
    data object Loading : UserState()
    data object Success : UserState()
    data class Error(val message: String) : UserState()
}