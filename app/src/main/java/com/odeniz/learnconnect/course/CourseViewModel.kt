package com.odeniz.learnconnect.course

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.entity.dao.UserCourseDao
import com.odeniz.learnconnect.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val purchasedCourseDao: UserCourseDao,
    private val courseList: CourseDao,
    private val dataSource: DataStoreManager
) : ViewModel() {

    private val _coursesState = MutableLiveData<UserCourseState>()
    val state: LiveData<UserCourseState> get() = _coursesState

    private suspend fun getUserId() = dataSource.userInfo.first().id

    fun getPurchasedCourses() {
        viewModelScope.launch {
            _coursesState.value = UserCourseState.Loading
            try {
                val purchased = purchasedCourseDao.getPurchasedByUser(getUserId().toInt()).first()
                val purchasedCourses = courseList.getCourseByIds(purchased.map { it }).first()
                _coursesState.value = UserCourseState.Success(purchasedCourses)

            } catch (e: Exception) {
                _coursesState.value = e.localizedMessage?.let { UserCourseState.Error(it) }
            }

        }
    }
}