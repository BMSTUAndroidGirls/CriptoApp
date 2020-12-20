package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.bmstuandroidgirls.criptoapp.settings.Settings


class MainActivity : AppCompatActivity(){
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PreferenceManager.getDefaultSharedPreferences(this).getString(getString(R.string.themes_key), "blue")
            ?.let { Settings.setCurrentTheme(it) }
        setTheme(Settings.getNewTheme())
        setContentView(R.layout.activity_main)

        navController = this.findNavController(R.id.main_navigation_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}