package com.bmstuandroidgirls.criptoapp.currency

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bmstuandroidgirls.criptoapp.R
import com.bmstuandroidgirls.criptoapp.network.CurrencyAPI
import com.bmstuandroidgirls.criptoapp.network.NetworkRequests

class CurrencyListFragment : Fragment() {
    private var data: ArrayList<CurrencyAPI.Datum>? = null
    private var networkRequests = NetworkRequests()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        if (savedInstanceState != null) {
            data = savedInstanceState.getSerializable("data") as ArrayList<CurrencyAPI.Datum>?
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mainView: View = inflater.inflate(R.layout.start_fragment, container, false)
        val recyclerView: RecyclerView = mainView.findViewById(R.id.list)
        var adapter: CurrencyDataAdapter
        if (data == null) {
            networkRequests.currenciesMutableLiveData
                .observe(viewLifecycleOwner, Observer { results ->
                    data = results as ArrayList<CurrencyAPI.Datum>?
                    Log.d("results", data.toString())
                    adapter = CurrencyDataAdapter(this, data!!)
                    recyclerView.adapter = adapter
                })
                networkRequests.getCurrencies()
        } else {
            adapter = CurrencyDataAdapter(this, (data)!!)
            recyclerView.adapter = adapter
        }

        val spanCount = resources.getInteger(R.integer.spanCount)
        val layoutManager = GridLayoutManager(activity, spanCount)
        recyclerView.layoutManager = layoutManager
        return mainView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("data", data)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
//                recreate()
                true
            }
            R.id.menu_settings ->{
                findNavController().navigate(R.id.navigation_settings)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
