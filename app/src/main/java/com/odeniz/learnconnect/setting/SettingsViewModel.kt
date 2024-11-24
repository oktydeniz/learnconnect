package com.odeniz.learnconnect.setting

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.odeniz.learnconnect.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataSource: DataStoreManager
) : ViewModel() {

    val darkMode = dataSource.darkMode.asLiveData()

    fun saveDarkModeStatus(isChecked: Boolean) {
        viewModelScope.launch {
            dataSource.saveDarkModeStatus(isChecked)
        }
    }

    fun logoutUser() {
        viewModelScope.launch {
            dataSource.clearUserData()
        }
    }

    fun applyDarkMode(isDarkMode: Boolean) {
        val mode = if (isDarkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}
