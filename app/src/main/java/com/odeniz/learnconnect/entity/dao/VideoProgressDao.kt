package com.odeniz.learnconnect.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.VideoProgress
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoProgressDao {

    @Query("SELECT * FROM video_progress WHERE videoId = :videoId AND userId = :userId")
    fun getUserProgress(videoId: Int, userId: Int): Flow<VideoProgress?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProgress(videoProgress: VideoProgress)

    @Query("SELECT videoId FROM video_progress WHERE userId = :userId AND courseId = :courseId ORDER BY lastWatched DESC LIMIT 1")
    fun getLastSeenVideoId(courseId: Int, userId: Int): Flow<Int>
}


