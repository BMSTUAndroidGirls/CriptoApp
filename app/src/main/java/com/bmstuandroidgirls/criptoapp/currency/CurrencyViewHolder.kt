package com.bmstuandroidgirls.criptoapp.currency

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.ViewHolder
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
//
                }
            }
        }
    }
}
