package com.bmstuandroidgirls.criptoapp.currency

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bmstuandroidgirls.criptoapp.MainActivity
import com.bmstuandroidgirls.criptoapp.PreferencesActivity
import com.bmstuandroidgirls.criptoapp.R
import com.bmstuandroidgirls.criptoapp.data.PreferencesInfo
import com.bmstuandroidgirls.criptoapp.network.CurrencyAPI
import com.bmstuandroidgirls.criptoapp.network.NetworkRequests


class CurrencyListFragment : Fragment() {
    private var data: ArrayList<CurrencyAPI.Datum>? = null
    private var networkRequests = NetworkRequests()
    private var url = "https://min-api.cryptocompare.com/documentation?key=Historical&cat=dataHistoday&api_key=600bf09ff8d82df6383db691c3873eb7fa6ea91651f8a33bfbd90dd2ddafcf4a"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        if (savedInstanceState != null) {
            data = savedInstanceState.getSerializable("data") as ArrayList<CurrencyAPI.Datum>?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainView: View = inflater.inflate(R.layout.start_fragment, container, false)
        val recyclerView: RecyclerView = mainView.findViewById(R.id.list)
        var adapter: CurrencyDataAdapter
        if (data == null) {
            networkRequests.currenciesMutableLiveData
                .observe(viewLifecycleOwner, { results ->
                    data = results as ArrayList<CurrencyAPI.Datum>?
                    Log.d("results", data.toString())
                    adapter = CurrencyDataAdapter(this, data!!)
                    recyclerView.adapter = adapter
                })

        } else {
            adapter = CurrencyDataAdapter(this, (data)!!)
            recyclerView.adapter = adapter
        }
        networkRequests.days = PreferenceManager.getDefaultSharedPreferences(activity).getString(getString(R.string.days_key), "10")!!.toInt()
        networkRequests.currency = PreferenceManager.getDefaultSharedPreferences(activity).getString(getString(R.string.currency_key), "USD")!!
        networkRequests.getCurrencies()

        mainView.findViewById<Button>(R.id.open_link).setOnClickListener {
            run {
                openWebPage(url)
            }
        }

        val spanCount = resources.getInteger(R.integer.spanCount)
        val layoutManager = GridLayoutManager(activity, spanCount)
        recyclerView.layoutManager = layoutManager
        return mainView
    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                networkRequests.getCurrencies()
                true
            }
            R.id.menu_settings -> {
//                findNavController().navigate(R.id.navigation_settings)
                val intent = Intent(activity, PreferencesActivity::class.java).apply {
                }
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
