package com.odeniz.learnconnect.search

import com.odeniz.learnconnect.entity.Category
import com.odeniz.learnconnect.entity.Course

sealed class SearchState {
    data object Loading : SearchState()
    data class Success(val category: List<Category>) : SearchState()
    data class SuccessSearch(val courses: List<Course>) : SearchState()
    data class Error(val message: String) : SearchState()
}