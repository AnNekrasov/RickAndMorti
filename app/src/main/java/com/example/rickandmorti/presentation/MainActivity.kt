package com.example.rickandmorti.presentation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//            setContentView(R.menu.bottom_nav_menu)

        bottomNavigation = findViewById(R.id.nav_view)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHost.navController
        bottomNavigation.setOnItemReselectedListener { item ->
            when (item.itemId) {
                R.id.characterListFragment -> {
                    // Respond to navigation item 1 reselection
                    navController.navigate(R.id.characterListFragment)
                }
                R.id.episodesListFragment -> {
                    navController.navigate(R.id.episodesListFragment)
                    // Respond to navigation item 2 reselection
                }
                R.id.locationListFragment -> {
                    navController.navigate(R.id.locationListFragment)

                }
            }
        }

//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home,
//            R.id.navigation_dashboard,
//            R.id.navigation_notifications,
//            ))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)

    }


}