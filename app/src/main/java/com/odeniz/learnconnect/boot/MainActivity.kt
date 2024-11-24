package com.odeniz.learnconnect.boot

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.odeniz.learnconnect.LoginActivity
import com.odeniz.learnconnect.HomeActivity
import com.odeniz.learnconnect.R
import com.odeniz.learnconnect.local.DataStoreManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            isDarkModeEnabled()
            val intent = Intent(
                this@MainActivity,
                if (isUserLoggedIn()) HomeActivity::class.java else LoginActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }


    private suspend fun isUserLoggedIn(): Boolean {
        return dataStoreManager.loginStatus.firstOrNull() ?: false
    }
    private suspend fun isDarkModeEnabled() {
        val isDarkMode = dataStoreManager.darkMode.firstOrNull() ?: false
        val mode = if (isDarkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}