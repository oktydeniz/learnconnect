package com.odeniz.learnconnect.home.state

import com.odeniz.learnconnect.entity.Course

sealed class HomeState {
    data object Loading : HomeState()
    data class Success(val topCourses: List<Course>, val newCourses: List<Course>) : HomeState()
    data class Error(val message: String) : HomeState()
}