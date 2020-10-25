package com.bmstuandroidgirls.criptoapp

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bmstuandroidgirls.criptoapp.databinding.StartFragmentBinding

class StartFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: StartFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.start_fragment, container, false)
        binding.titleText.text = getString(R.string.app_default)
        binding.randomText.text = getString(R.string.app_help)
        return binding.root
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


