package com.odeniz.learnconnect.util

class VerifyFields {

    companion object {

        fun isValidUsername(username: String): Boolean {
            return username.isNotEmpty() && username.length >= 3
        }

        fun isValidEmail(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())
        }

        fun isValidPassword(password: String): Boolean {
            return password.length >= 6
        }

        fun doPasswordsMatch(password: String, passwordVerify: String): Boolean {
            return password == passwordVerify
        }

    }

}