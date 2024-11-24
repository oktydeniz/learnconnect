package com.odeniz.learnconnect.di

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.odeniz.learnconnect.boot.CategoryInitializer
import com.odeniz.learnconnect.boot.CourseInitializer
import com.odeniz.learnconnect.boot.CourseVideosInitializer
import com.odeniz.learnconnect.entity.dao.CategoryDao
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.entity.dao.UserCourseDao
import com.odeniz.learnconnect.entity.dao.UserDao
import com.odeniz.learnconnect.entity.dao.VideoDao
import com.odeniz.learnconnect.entity.dao.WishlistDao
import com.odeniz.learnconnect.local.AppDatabase
import com.odeniz.learnconnect.local.DataStoreManager
import com.odeniz.learnconnect.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppConstants.APP_DATABASE
        )
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    GlobalScope.launch(Dispatchers.IO) {
                        val database = provideDatabase(context)
                        CategoryInitializer.initializeCategories(context, database)
                        CourseInitializer.initializeCourses(database)
                        CourseVideosInitializer.initialize(database)
                    }
                }
            })
            .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideCourseDao(database: AppDatabase): CourseDao {
        return database.courseDao()
    }

    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideWishlistDao(database: AppDatabase): WishlistDao {
        return database.wishlistDao()
    }

    @Provides
    fun provideUserCourseDao(database: AppDatabase): UserCourseDao {
        return database.userCourseDao()
    }

    @Provides
    fun provideVideoDao(database: AppDatabase): VideoDao {
        return database.videoDao()
    }

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext context: Context): Resources {
        return context.resources
    }
}