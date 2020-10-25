package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class PreferencesActivity : AppCompatActivity() {
    private val MESSAGE = "com.bmstuandroidgirls.criptoapp.currency.MESSAGE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences_activity)
        val message = intent.getStringExtra(MESSAGE)
    }
}