package com.odeniz.learnconnect.entity.repository

import com.odeniz.learnconnect.entity.Category
import com.odeniz.learnconnect.entity.Course
import com.odeniz.learnconnect.entity.User
import com.odeniz.learnconnect.entity.Video
import com.odeniz.learnconnect.entity.dao.CategoryDao
import com.odeniz.learnconnect.entity.dao.CourseDao
import com.odeniz.learnconnect.entity.dao.UserDao
import com.odeniz.learnconnect.entity.dao.VideoDao
import kotlinx.coroutines.flow.Flow

class AppRepository(
    private val userDao: UserDao,
    private val courseDao: CourseDao,
    private val categoryDao: CategoryDao,
    private val videoDao: VideoDao
) {

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun getCoursesByCategory(categoryId: Int): Flow<List<Course>> {
        return courseDao.getCoursesByCategory(categoryId)
    }

    fun getCoursesBySubTag(subTag: String): Flow<List<Course>> {
        return courseDao.getCoursesBySubTag(subTag)
    }

    fun getCategoryById(categoryId: Int): Flow<Category?> {
        return categoryDao.getCategoryById(categoryId)
    }

    fun insertCourse(course: Course) {
        courseDao.insertCourse(course)
    }

    fun getVideosByCourse(courseId: Int): Flow<List<Video>> {
        return videoDao.getVideosByCourse(courseId)
    }
}
