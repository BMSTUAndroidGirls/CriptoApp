package com.bmstuandroidgirls.criptoapp
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.preference.*

class SettingsPreferencesFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
        val daysPref = findPreference<EditTextPreference>(
            getString(R.string.days_key)
        )
        daysPref?.setOnPreferenceChangeListener { p, v ->
            onPreferenceChange(p, v)
        }
        val daysPrefValue = PreferenceManager.getDefaultSharedPreferences(activity).getString(getString(R.string.days_key), "2")
        daysPref?.summary = "The days range is: $daysPrefValue"
        val currencyPref = findPreference<ListPreference>(
            getString(R.string.currency_key)
        )
        currencyPref?.setOnPreferenceChangeListener { p, v ->
            onPreferenceChange(p, v)
        }
        val currencyPrefValue = PreferenceManager.getDefaultSharedPreferences(activity).getString(getString(R.string.currency_key), "USD")
        currencyPref?.summary = "The currency is: $currencyPrefValue"

        val themePref = findPreference<ListPreference>(
            getString(R.string.themes_key)
        )
        themePref?.setOnPreferenceChangeListener { p, v ->
            onPreferenceChange(p, v)
        }
        val themePrefValue = PreferenceManager.getDefaultSharedPreferences(activity).getString(getString(R.string.themes_key), "Blue")
        themePref?.summary = "The theme is: $themePrefValue"
    }

     private fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
         if (preference?.key == getString(R.string.days_key)) {
             try {
                 val days = newValue.toString().toInt()
                 if (days < 0) {
                     Toast.makeText(context, "Should be positive!", Toast.LENGTH_SHORT).show()
                 } else {
                     preference.summary = "The days range is: ${newValue.toString()}"
                 }
                 return days >= 0
             } catch (nfe: NumberFormatException) {
                 Toast.makeText(context, "Should be number!", Toast.LENGTH_SHORT).show()
                 return false
             }
         }
         if (preference?.key == getString(R.string.themes_key)) {
             preference.summary = "The theme is: $newValue"
         }
         if (preference?.key == getString(R.string.currency_key)) {
             preference.summary = "The currency is: $newValue"

         }
         return true
     }
}