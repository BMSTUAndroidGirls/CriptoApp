package com.bmstuandroidgirls.criptoapp
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingsPreferencesFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
        findPreference<EditTextPreference>(
                getString(R.string.days_key)
        )?.setOnPreferenceChangeListener { p, v ->
            onPreferenceChange(p, v)
        }
    }

     private fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        if (preference?.key == getString(R.string.days_key)) {
            try {
                val days = newValue.toString().toInt()
                return days >= 0
            } catch (nfe: NumberFormatException) {
                return false
            }
        }
        return true
    }
}