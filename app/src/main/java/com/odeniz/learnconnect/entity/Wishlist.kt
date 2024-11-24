package com.odeniz.learnconnect.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants

@Entity(tableName = AppConstants.WISHLIST_ENTITY)
data class Wishlist(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val courseId: Int,
    val addedDate: String
)
