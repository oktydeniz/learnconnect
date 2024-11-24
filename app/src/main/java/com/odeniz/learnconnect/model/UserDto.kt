package com.odeniz.learnconnect.model

data class UserDto(
    val fullName: String,
    val password: String,
    val passwordVerify: String,
    val email: String,
)
