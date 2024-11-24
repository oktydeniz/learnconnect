package com.odeniz.learnconnect.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants
import java.io.Serializable

@Entity(tableName = AppConstants.VIDEO_ENTITY)
data class Video(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val courseId: Int,
    val title: String,
    val url: String,
    val duration: Int,
    val about: String,
    val order: Int,
    val thumbnailUrl: String? = null,
): Serializable