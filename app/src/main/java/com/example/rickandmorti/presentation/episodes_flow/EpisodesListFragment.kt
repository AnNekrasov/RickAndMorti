package com.example.rickandmorti.presentation.episodes_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentCharacterListBinding
import com.example.rickandmorti.databinding.FragmentEpisodesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class EpisodesListFragment : Fragment() {
    private lateinit var binding: FragmentEpisodesListBinding
    val viewModel: EpisodesListViewModel by viewModels()
    val adapter by lazy { EpisodesListAdapter() }
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //    swipeRefreshLayout = binding.swipeRefreshEpisode
        //   binding.swipeRefreshEpisode.isRefreshing=true
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadEpisodeList()
        binding.rvEpisodeList.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        binding.swipeRefreshEpisode.setOnRefreshListener {
            viewModel.loadEpisodeList()
                     binding.rvEpisodeList.adapter = adapter
                   viewModel.liveData.observe(viewLifecycleOwner) {
                     adapter.setList(it)
                   adapter.notifyDataSetChanged()
                     }
            binding.swipeRefreshEpisode.isRefreshing = false
        }
    }
}
