package com.odeniz.learnconnect.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants
import java.io.Serializable

@Entity(tableName = AppConstants.CATEGORY_ENTITY)
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val categoryName: String,
    val slug: String
): Serializable
