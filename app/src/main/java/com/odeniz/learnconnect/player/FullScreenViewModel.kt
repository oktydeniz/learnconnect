package com.odeniz.learnconnect.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.entity.VideoProgress
import com.odeniz.learnconnect.entity.dao.VideoProgressDao
import com.odeniz.learnconnect.local.DataStoreManager
import com.odeniz.learnconnect.util.DateUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FullScreenViewModel @Inject constructor(
    private val videoProgressDao: VideoProgressDao,
    private val dataSource: DataStoreManager
) : ViewModel() {

    private val _state = MutableLiveData<FullScreenState>()
    val state: LiveData<FullScreenState> get() = _state

    fun getProgress(videoId: Int) {
        _state.value = FullScreenState.Loading
        viewModelScope.launch {
            try {
                val result = videoProgressDao.getUserProgress(videoId, getUserId().toInt()).first()
                _state.value = result?.let { FullScreenState.FoundProgress(it) }
            } catch (e: Exception) {
                _state.value = e.localizedMessage?.let { FullScreenState.Error(it) }
            }
        }
    }

    fun saveProgress(time: Float, videoId: Int, courseId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val userId = getUserId().toInt()
            val currentDate = DateUtil.getEnrollmentDate()

            val existingProgress = videoProgressDao.getUserProgress(videoId, userId).firstOrNull()
            val videoProgress = existingProgress?.copy(
                progress = time,
                lastWatched = currentDate
            ) ?: VideoProgress(
                userId = userId,
                videoId = videoId,
                progress = time,
                lastWatched = currentDate,
                courseId = courseId
            )
            videoProgressDao.saveProgress(videoProgress)
        }
    }

    private suspend fun getUserId() = dataSource.userInfo.first().id
}