package com.bmstuandroidgirls.criptoapp

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.bmstuandroidgirls.criptoapp.data.PreferencesInfo
import com.bmstuandroidgirls.criptoapp.network.CurrencyAPI


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}