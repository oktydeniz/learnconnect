package com.odeniz.learnconnect.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants

@Entity(tableName = AppConstants.VIDEO_PROGRESS_ENTITY)
data class VideoProgress(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val videoId: Int,
    val progress: Int,
    val lastWatched: String
)
