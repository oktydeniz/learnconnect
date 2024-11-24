package com.odeniz.learnconnect.entity

import androidx.datastore.core.Serializer
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants
import java.io.Serializable

@Entity(tableName = AppConstants.COURSE_ENTITY)
data class Course(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val thumbnailUrl: String? = null,
    val averageRating: Float = 0.0f,
    val ratingCount: Int = 0,
    val categoryId: Int,
    val subTags: String
): Serializable
