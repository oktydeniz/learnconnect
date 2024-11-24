package com.odeniz.learnconnect

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.odeniz.learnconnect.databinding.ActivityMainBinding
import com.odeniz.learnconnect.setting.SettingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_fragment_container_view) as NavHostFragment
        val navController = navHostFragment!!.navController
        NavigationUI.setupWithNavController(binding.mainBottomNav, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            updateToolbarTitle(destination.id)
            setupBackButton(destination.id, navController)
        }

        binding.settingsIcon.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateToolbarTitle(destinationId: Int) {
        binding.mainToolbarTitle.text = when (destinationId) {
            R.id.courseFragment -> getString(R.string.courses)
            R.id.wishListFragment -> getString(R.string.wishlist)
            R.id.profileFragment -> getString(R.string.profile)
            R.id.searchFragment -> getString(R.string.search)
            else -> getString(R.string.app_name)
        }
    }

    private fun setupBackButton(destinationId: Int, navController: NavController) {
        if (destinationId !in listOf(
                R.id.courseFragment,
                R.id.wishListFragment,
                R.id.profileFragment,
                R.id.searchFragment,
                R.id.homeFragment
            )
        ) {
            binding.backActionFragment.visibility = View.VISIBLE
            binding.backActionFragment.setOnClickListener {
                navController.popBackStack()
            }
        } else {
            binding.backActionFragment.visibility = View.GONE
        }
    }


}