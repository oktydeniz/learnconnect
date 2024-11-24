package com.odeniz.learnconnect.search

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.dao.CourseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryItemsViewModel @Inject constructor(
    private val courseDao: CourseDao,
    private val resources: Resources
) : ViewModel() {
    private val _state = MutableLiveData<SearchState>()
    val state: LiveData<SearchState> = _state

    fun getCourses(categoryId: Int) {
        _state.value = SearchState.Loading
        viewModelScope.launch {
            try {
                val courses = courseDao.getCoursesByCategory(categoryId).first()
                _state.value = SearchState.SuccessSearch(courses)
            } catch (e: Exception) {
                _state.value =
                    SearchState.Error(e.message ?: resources.getString(R.string.unknown_error))
            }
        }
    }
}