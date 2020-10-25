package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bmstuandroidgirls.criptoapp.databinding.CurrencyFragmentBinding

class CurrencyFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: CurrencyFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.currency_fragment, container, false)
        binding.titleText.text = getString(R.string.app_default)
        binding.randomText.text = getString(R.string.app_help)
        return binding.root
    }
}