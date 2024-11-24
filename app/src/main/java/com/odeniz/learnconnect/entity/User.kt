package com.odeniz.learnconnect.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.odeniz.learnconnect.util.AppConstants

@Entity(tableName = AppConstants.USER_ENTITY)
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val email:String,
    val password:String,
    val fullName:String,
    val profileImage:Bitmap?,
    val about:String?,
    val darkMode:Boolean = false,
)
