package com.bmstuandroidgirls.criptoapp.settings
import android.content.res.Resources
import android.util.Log
import com.bmstuandroidgirls.criptoapp.R
import java.util.*

object Settings {
    var currentLang: Int = 0;
    private val langMap: Map<Int, Locale> = mapOf(0 to Locale("en_US"), 1 to Locale("ru"))
    var currentTheme: Int = 0
    private val themeMap: Map<Int, Int> = mapOf(0 to R.style.Theme_CriptoApp, 1 to R.style.Theme_CriptoApp2)

    fun setCurrentTheme(theme: String) {
        if (theme == "Green") {
            currentTheme = 1;
        } else {
            currentTheme = 0;
        }
    }


    fun getNewTheme(): Int {
        val returnValue: Int = themeMap[currentTheme] ?: return R.style.Theme_CriptoApp;
        return returnValue
    }
}