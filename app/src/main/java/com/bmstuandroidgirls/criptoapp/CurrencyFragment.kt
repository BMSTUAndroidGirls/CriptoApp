package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bmstuandroidgirls.criptoapp.data.CurrencyInfo
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
        val arguments = this.arguments
        val currencyInfo: CurrencyInfo? = arguments!!.getSerializable("card_info") as CurrencyInfo?
        if (currencyInfo != null) {
            binding.highText.text = currencyInfo.high
            binding.lowText.text = currencyInfo.low
        }
        return binding.root
    }
}