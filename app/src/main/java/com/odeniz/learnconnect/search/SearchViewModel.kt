package com.odeniz.learnconnect.search

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.entity.dao.CategoryDao
import com.odeniz.learnconnect.entity.dao.CourseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val categoryDao: CategoryDao,
    private val courseDao: CourseDao,
    private val resources: Resources,
) : ViewModel() {

    private val _state = MutableLiveData<SearchState>()
    val state: LiveData<SearchState> get() = _state

    fun searchInDatabase(it: String) {
        _state.value = SearchState.Loading
        viewModelScope.launch {
            val courses = courseDao.searchCoursesByTitleOrSubTags(it).first()
            if (courses.isNotEmpty()) {
                _state.value = SearchState.SuccessSearch(courses)
            } else {
                _state.value = SearchState.Error(resources.getString(R.string.no_data_found))
            }
        }
    }

    fun getCategories() {
        _state.value = SearchState.Loading
        viewModelScope.launch {
            val categories = categoryDao.getAllCategories().first()
            if (categories.isNotEmpty()) {
                _state.value = SearchState.Success(categories)
            } else {
                _state.value = SearchState.Error(resources.getString(R.string.no_data_found))
            }
        }
    }
}