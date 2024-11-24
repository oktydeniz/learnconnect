package com.odeniz.learnconnect.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.odeniz.learnconnect.entity.Category
import com.odeniz.learnconnect.entity.Course
import com.odeniz.learnconnect.entity.User
import com.odeniz.learnconnect.entity.UserCourse
import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.entity.Wishlist
import com.odeniz.learnconnect.entity.dao.CategoryDao
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.entity.dao.UserCourseDao
import com.odeniz.learnconnect.entity.dao.UserDao
import com.odeniz.learnconnect.entity.dao.VideoDao
import com.odeniz.learnconnect.entity.dao.WishlistDao
import com.odeniz.learnconnect.entity.helper.Converters

@Database(
    entities = [User::class, Course::class, Category::class,
        Video::class, UserCourse::class, Wishlist::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun courseDao(): CourseDao
    abstract fun categoryDao(): CategoryDao
    abstract fun videoDao(): VideoDao
    abstract fun userCourseDao(): UserCourseDao
    abstract fun wishlistDao(): WishlistDao

}