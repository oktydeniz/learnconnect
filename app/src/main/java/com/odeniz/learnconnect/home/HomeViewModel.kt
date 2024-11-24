package com.odeniz.learnconnect.home

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val courseDao: CourseDao,
    private val resources: Resources
) : ViewModel() {

    private val _homeState = MutableLiveData<HomeState>()
    val homeState: LiveData<HomeState> get() = _homeState
    private var isDataLoaded = false

    fun getForHomePage() {
        if (!isDataLoaded) {
            viewModelScope.launch {
                _homeState.value = HomeState.Loading
                val topCourses = courseDao.getTopCourses().first()
                val newCourses = courseDao.getHomeCourses().first()
                if (topCourses.isNotEmpty() && newCourses.isNotEmpty()) {
                    _homeState.value = HomeState.Success(topCourses, newCourses)
                    isDataLoaded = true
                } else {
                    _homeState.value =
                        HomeState.Error(resources.getString(R.string.failed_to_get_courses))
                }
            }
        }
    }
}