package com.example.rickandmorti.presentation.location_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentEpisodesListBinding
import com.example.rickandmorti.databinding.FragmentLocationListBinding
import com.example.rickandmorti.databinding.ItemLocationBinding
import dagger.hilt.android.AndroidEntryPoint

//
@AndroidEntryPoint

class LocationListFragment : Fragment() {
    private lateinit var binding: FragmentLocationListBinding
    val viewModel:LocationListViewModel by viewModels()
    val adapter by lazy { LocationListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadLocationList()
        binding.rvLocationList.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.swipeRefreshLocation.setOnRefreshListener {
            viewModel.loadLocationList()
            binding.rvLocationList.adapter = adapter
            viewModel.liveData.observe(viewLifecycleOwner) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.swipeRefreshLocation.isRefreshing=false
        }
    }
}