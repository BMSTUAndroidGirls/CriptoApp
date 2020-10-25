package com.bmstuandroidgirls.criptoapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bmstuandroidgirls.criptoapp.databinding.SettingsFragmentBinding
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.preference.Preference

class SettingsPreferencesFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference)
    }
}