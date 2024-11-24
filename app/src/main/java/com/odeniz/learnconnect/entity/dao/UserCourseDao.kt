package com.odeniz.learnconnect.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.UserCourse
import com.odeniz.learnconnect.entity.Wishlist
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCourseDao {

    @Query("SELECT EXISTS(SELECT 1 FROM user_course WHERE courseId = :courseId AND userId = :userId)")
    fun isPurchased(courseId: Int, userId: Long): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(course: UserCourse): Long

    @Query("SELECT courseId FROM user_course WHERE userId = :userId")
    fun getPurchasedByUser(userId: Int): Flow<List<Int>>
}