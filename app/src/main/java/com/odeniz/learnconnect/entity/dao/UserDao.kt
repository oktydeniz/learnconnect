package com.odeniz.learnconnect.entity.dao

import android.graphics.Bitmap
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.odeniz.learnconnect.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getUser(email: String, password: String): Flow<User?>

    @Query("SELECT COUNT(*) FROM user WHERE email = :email")
    fun isMailExist(email: String): Flow<Int>

    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    fun getUserByMail(email: String): Flow<User>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Long): Flow<User>

    @Query("UPDATE user SET email = :mail, fullName = :name, about = :about WHERE id = :id")
    fun updateProfile(id: Long, name: String, mail: String, about: String)

    @Query("UPDATE user SET email = :mail, fullName = :name, about = :about, profileImage = :uri WHERE id = :id")
    fun updateProfileWithImage(id: Long, name: String, mail: String, about: String, uri: Bitmap)

}