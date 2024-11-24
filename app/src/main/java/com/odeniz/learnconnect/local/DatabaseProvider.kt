package com.odeniz.learnconnect.local

import android.content.Context
import androidx.room.Room
import com.odeniz.learnconnect.util.AppConstants

object DatabaseProvider {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                AppConstants.APP_DATABASE
            ).build()
            INSTANCE = instance
            instance
        }
    }
}