package com.odeniz.learnconnect.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.entity.dao.WishlistDao
import com.odeniz.learnconnect.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(
    private val wishlistDao: WishlistDao,
    private val courseDao: CourseDao,
    private val dataSource: DataStoreManager
) : ViewModel() {

    private val _state = MutableLiveData<WishlistState>()
    val state: LiveData<WishlistState> get() = _state

    private suspend fun getUserId() = dataSource.userInfo.first().id

    fun getUserList() {
        viewModelScope.launch{
            _state.value = WishlistState.Loading
            try {
                val list = wishlistDao.getUserWishlist(getUserId()).first()
                val courseList = courseDao.getCourseByIds(list.map { it }).first()
                _state.value = WishlistState.Success(courseList)
            }catch (e: Exception){
                _state.value = e.localizedMessage?.let { WishlistState.Error(it) }
            }
        }
    }

}