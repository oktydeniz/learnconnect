package com.odeniz.learnconnect.home.state

import com.odeniz.learnconnect.entity.Category
import com.odeniz.learnconnect.entity.Video

sealed class DetailState {
    data object Loading : DetailState()
    data class SuccessFindCategory(val category: Category) : DetailState()
    data class PurchaseStatus(val isPurchased: Boolean, val isInWishlist: Boolean) : DetailState()
    data class CourseVideos(val videos: List<Video>) : DetailState()
    data class CourseLastSeenVideos(val id: Int) : DetailState()
    data class Error(val message: String) : DetailState()
}