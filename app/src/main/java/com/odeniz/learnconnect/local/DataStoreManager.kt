package com.odeniz.learnconnect.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.odeniz.learnconnect.entity.User
import com.odeniz.learnconnect.util.AppConstants
import com.odeniz.learnconnect.util.AppConstants.DARK_MODE_KEY
import com.odeniz.learnconnect.util.AppConstants.LOGIN_KEY
import com.odeniz.learnconnect.util.AppConstants.USER_PREF
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(USER_PREF)

class DataStoreManager private constructor(private val context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: DataStoreManager? = null

        fun getInstance(context: Context): DataStoreManager {
            return INSTANCE ?: synchronized(this) {
                val instance = DataStoreManager(context)
                INSTANCE = instance
                instance
            }
        }
    }

    private val dataStorage: DataStore<Preferences> = context.datastore

    suspend fun saveLoginStatus(isLoggedIn: Boolean) {
        val key = booleanPreferencesKey(LOGIN_KEY)
        dataStorage.edit {
            it[key] = isLoggedIn
        }
    }

    suspend fun saveDarkModeStatus(isEnable: Boolean) {
        val key = booleanPreferencesKey(DARK_MODE_KEY)
        dataStorage.edit {
            it[key] = isEnable
        }
    }

    suspend fun saveUserInfo(
        appUser: User
    ) {
        dataStorage.edit { preferences ->
            appUser.fullName.let { preferences[stringPreferencesKey(AppConstants.USER_NAME)] = it }
            appUser.email.let { preferences[stringPreferencesKey(AppConstants.USER_EMAIL)] = it }
            appUser.id.let { preferences[longPreferencesKey(AppConstants.USER_ID)] = it }
        }
    }

    val userInfo: Flow<User> = dataStorage.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            User(
                id = preferences[longPreferencesKey(AppConstants.USER_ID)] ?: 0,
                fullName = preferences[stringPreferencesKey(AppConstants.USER_NAME)] ?: "",
                email = preferences[stringPreferencesKey(AppConstants.USER_EMAIL)] ?: "",
                password = "",
                about = "",
                profileImage = null
            )
        }

    val loginStatus: Flow<Boolean> = dataStorage.data.catch { e ->
        if (e is IOException) {
            emit(emptyPreferences())
        } else {
            throw e
        }
    }.map { p ->
        val loginKey = booleanPreferencesKey(LOGIN_KEY)
        p[loginKey] ?: false
    }


    val darkMode: Flow<Boolean> = dataStorage.data.catch { e ->
        if (e is IOException) {
            emit(emptyPreferences())
        } else {
            throw e
        }
    }.map { p ->
        val loginKey = booleanPreferencesKey(DARK_MODE_KEY)
        p[loginKey] ?: false
    }

    suspend fun clearUserData() {
        dataStorage.edit { preferences ->
            preferences.clear()
        }
    }
}