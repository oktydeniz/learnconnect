package com.odeniz.learnconnect.setting

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.odeniz.learnconnect.LoginActivity
import com.odeniz.learnconnect.databinding.ActivitySettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingActivity : AppCompatActivity() {

    private val viewModel: SettingsViewModel by viewModels()
    private val binding by lazy {
        ActivitySettingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
        observeSettings()
    }

    private fun setupUI() {
        binding.apply {
            darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.saveDarkModeStatus(isChecked)
            }
            backBtn.setOnClickListener { finish() }
            logoutText.setOnClickListener {
                viewModel.logoutUser()
                navigateToLogin()
            }
        }
    }

    private fun observeSettings() {
        viewModel.darkMode.observe(this) { isDarkModeEnabled ->
            binding.darkModeSwitch.isChecked = isDarkModeEnabled
            viewModel.applyDarkMode(isDarkModeEnabled)
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
