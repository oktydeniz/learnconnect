package com.odeniz.learnconnect.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.Wishlist
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Query("SELECT EXISTS(SELECT 1 FROM wishlist WHERE courseId = :courseId AND userId = :userId)")
    fun isInWishlist(courseId: Int, userId: Long): Flow<Boolean>

    /*
    @Query("INSERT OR IGNORE INTO wishlist (courseId, userId) VALUES (:courseId, :userId)")
    fun insert(courseId: Int, userId: Int) : Flow<Long>
     */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(wishlist: Wishlist): Long

    @Query("DELETE FROM wishlist WHERE courseId = :courseId AND userId = :userId")
    fun delete(courseId: Int, userId: Long)

    @Query("SELECT courseId FROM wishlist WHERE userId = :userId")
    fun getUserWishlist(userId: Long): Flow<List<Int>>
}