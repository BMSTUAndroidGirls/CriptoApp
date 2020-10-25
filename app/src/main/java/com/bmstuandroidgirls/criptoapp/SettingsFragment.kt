package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bmstuandroidgirls.criptoapp.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding: SettingsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.settings_fragment, container, false)
//        binding.titleText.text = getString(R.string.app_default)
//        binding.randomText.text = getString(R.string.app_help)
//        return binding.root
//    }

}