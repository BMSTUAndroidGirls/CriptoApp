package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bmstuandroidgirls.criptoapp.settings.Settings


class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(Settings.getNewTheme())
        setContentView(R.layout.preferences_activity)
    }
}