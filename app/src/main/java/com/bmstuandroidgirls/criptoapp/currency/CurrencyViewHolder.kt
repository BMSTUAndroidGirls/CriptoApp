package com.bmstuandroidgirls.criptoapp.currency

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bmstuandroidgirls.criptoapp.R
import com.bmstuandroidgirls.criptoapp.data.CurrencyInfo
import com.bmstuandroidgirls.criptoapp.databinding.CurrencyViewBinding
import com.bmstuandroidgirls.criptoapp.network.CurrencyAPI

class CurrencyViewHolder(val binding: CurrencyViewBinding, val fragment: Fragment) :
    ViewHolder(binding.root) {
    fun bind(cryptoData: CurrencyAPI.Datum?) {
        with(binding) {
            if (cryptoData != null) {
                cardTitle.text = cryptoData.time.toString()
                cardSecondaryText.text = cryptoData.high.toString()
                cardSupportingText.text = cryptoData.low.toString()
                cardButton.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putSerializable("card_info", CurrencyInfo(cryptoData.high.toString(), cryptoData.low.toString()))
                    fragment.findNavController().navigate(R.id.navigation_currency, bundle)
                }
            }
        }
    }
}
