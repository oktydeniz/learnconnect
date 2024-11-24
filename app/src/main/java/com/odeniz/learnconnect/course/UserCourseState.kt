package com.odeniz.learnconnect.course

import com.odeniz.learnconnect.entity.Course

sealed class UserCourseState {
    data object Loading : UserCourseState()
    data class Success(val userCourses: List<Course>) : UserCourseState()
    data class Error(val message: String) : UserCourseState()

}