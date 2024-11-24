package com.odeniz.learnconnect.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants

@Entity(tableName = AppConstants.COMMENT_ENTITY)
data class Comment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val courseId: Int,
    val rating: Float,
    val comment: String?,
    // ISO 8601 date-time string format
    val createdAt: String
)
