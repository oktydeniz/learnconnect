package com.odeniz.learnconnect.home

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.UserCourse
import com.odeniz.learnconnect.entity.Wishlist
import com.odeniz.learnconnect.entity.dao.CategoryDao
import com.odeniz.learnconnect.entity.dao.UserCourseDao
import com.odeniz.learnconnect.entity.dao.VideoDao
import com.odeniz.learnconnect.entity.dao.VideoProgressDao
import com.odeniz.learnconnect.entity.dao.WishlistDao
import com.odeniz.learnconnect.home.state.DetailState
import com.odeniz.learnconnect.local.DataStoreManager
import com.odeniz.learnconnect.util.DateUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val categoryDao: CategoryDao,
    private val wishlistDao: WishlistDao,
    private val videoDao: VideoDao,
    private val userCourse: UserCourseDao,
    private val resources: Resources,
    private val progressDao: VideoProgressDao,
    private val dataSource: DataStoreManager
) : ViewModel() {

    private val _detailState = MutableLiveData<DetailState>()
    val detailState: LiveData<DetailState> get() = _detailState

    fun getCategory(categoryId: Int) {
        viewModelScope.launch {
            val result = categoryDao.getCategoryById(categoryId).first()
            if (result != null) {
                _detailState.value = DetailState.SuccessFindCategory(result)
            } else {
                _detailState.value =
                    DetailState.Error(resources.getString(R.string.category_not_found))
            }
        }
    }

    fun checkPurchaseAndWishlistStatus(categoryId: Int) {
        viewModelScope.launch {
            try {
                val isPurchased = userCourse.isPurchased(categoryId, getUserId()).first()
                if (isPurchased) {
                    // If it is purchased, do not check the wishlist.
                    _detailState.value =
                        DetailState.PurchaseStatus(isPurchased = true, isInWishlist = false)
                } else {
                    // If it is not purchased, check the wishlist status.
                    val isInWishlist = wishlistDao.isInWishlist(categoryId, getUserId()).first()
                    _detailState.value =
                        DetailState.PurchaseStatus(isPurchased = false, isInWishlist = isInWishlist)
                }
            } catch (e: Exception) {
                _detailState.value = DetailState.Error(resources.getString(R.string.unknown_error))
            }
        }
    }

    private suspend fun getUserId() = dataSource.userInfo.first().id

    fun addToWishlist(id: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != null) {
                wishlistDao.insert(
                    Wishlist(
                        userId = getUserId().toInt(),
                        courseId = id,
                        addedDate = ""
                    )
                )
            }
        }
    }

    fun getCourseVideos(courseId: Int) {
        viewModelScope.launch {
            try {
                val result = videoDao.getCourseVideos(courseId).first()
                _detailState.value = DetailState.CourseVideos(result)
            } catch (e: Exception) {
                _detailState.value = DetailState.Error(resources.getString(R.string.unknown_error))
            }
        }
    }

    fun removeFromWishlist(id: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != null) {
                wishlistDao.delete(id, getUserId())
            }
        }
    }

    fun purchase(id: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != null) {
                val formattedDate = DateUtil.getEnrollmentDate()
                val isInWishlist = wishlistDao.isInWishlist(id, getUserId()).first()
                if (isInWishlist) {
                    wishlistDao.delete(id, getUserId())
                }
                userCourse.insert(
                    UserCourse(
                        userId = getUserId().toInt(),
                        courseId = id,
                        enrollmentDate = formattedDate
                    )
                )
            }
        }
    }

    fun getLastSeenVideo(courseId: Int) {
        viewModelScope.launch {
            try {
                val result =
                    progressDao.getLastSeenVideoId(courseId, getUserId().toInt()).firstOrNull()
                if (result != null) {
                    _detailState.value = DetailState.CourseLastSeenVideos(result)
                } else {
                    _detailState.value = DetailState.CourseLastSeenVideos(-1)
                }
            } catch (e: Exception) {
                _detailState.value = DetailState.CourseLastSeenVideos(-1)
            }
        }
    }
}