package com.odeniz.learnconnect.entity.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.Course
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(categories: List<Course>)

    @Query("SELECT * FROM course WHERE categoryId = :categoryId")
    fun getCoursesByCategory(categoryId: Int): Flow<List<Course>>

    @Query("SELECT * FROM course WHERE subTags LIKE :subTag")
    fun getCoursesBySubTag(subTag: String): Flow<List<Course>>

    @Query("""
        SELECT * 
        FROM course 
        WHERE 
            subTags LIKE '%' || :query || '%' 
            OR 
            title LIKE '%' || :query || '%'
        """)
    fun searchCoursesByTitleOrSubTags(query: String): Flow<List<Course>>

    @Query("SELECT * FROM course ORDER BY averageRating DESC, ratingCount DESC LIMIT 5")
    fun getTopCourses(): Flow<List<Course>>

    @Query("SELECT * FROM course ORDER BY RANDOM() LIMIT 10")
    fun getHomeCourses(): Flow<List<Course>>

    @Query("SELECT * FROM course WHERE id IN (:map)")
    fun getCourseByIds(map: List<Int>): Flow<List<Course>>
}