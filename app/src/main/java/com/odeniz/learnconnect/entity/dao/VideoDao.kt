package com.odeniz.learnconnect.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.Video
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(videos: List<Video>)

    @Query("SELECT * FROM video WHERE courseId = :courseId")
    fun getVideosByCourse(courseId: Int): Flow<List<Video>>

    @Query("SELECT * FROM video WHERE courseId = :courseId ORDER BY `order` ASC")
    fun getCourseVideos(courseId: Int): Flow<List<Video>>
}