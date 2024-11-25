package com.odeniz.learnconnect.player

import com.odeniz.learnconnect.entity.VideoProgress

sealed class FullScreenState {
    data object Loading : FullScreenState()
    data class FoundProgress(val videoProgress: VideoProgress) : FullScreenState()
    data class Error(val message: String) : FullScreenState()
}