package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bmstuandroidgirls.criptoapp.data.CurrencyInfo
import com.bmstuandroidgirls.criptoapp.databinding.CurrencyFragmentBinding

class CurrencyFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
            binding.currInfo.text = currencyInfo.currency
        }
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_return, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_return -> {
                findNavController().navigate(R.id.to_start)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}