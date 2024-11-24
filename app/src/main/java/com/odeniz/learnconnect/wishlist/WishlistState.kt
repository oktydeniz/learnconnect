package com.odeniz.learnconnect.wishlist

import com.odeniz.learnconnect.entity.Course
import com.odeniz.learnconnect.entity.User

sealed class WishlistState {
    data object Loading : WishlistState()
    data class Success(val courses: List<Course>) : WishlistState()
    data class Error(val message: String) : WishlistState()
}