package com.bmstuandroidgirls.criptoapp.currency

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bmstuandroidgirls.criptoapp.databinding.CurrencyViewBinding
import com.bmstuandroidgirls.criptoapp.network.CurrencyAPI

class CurrencyDataAdapter(fragment: Fragment?, data: ArrayList<CurrencyAPI.Datum>?) :
    RecyclerView.Adapter<CurrencyViewHolder>() {
    private var cards: ArrayList<CurrencyAPI.Datum>? = data
    private val fragment: Fragment = fragment as CurrencyListFragment

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CurrencyViewBinding = CurrencyViewBinding.inflate(layoutInflater, parent, false)
        return CurrencyViewHolder(binding, fragment)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) = holder.bind(cards?.get(position))

    override fun getItemCount(): Int {
        if (cards == null) {
            return 0
        } else {
            return cards!!.size
        }

    }
}
