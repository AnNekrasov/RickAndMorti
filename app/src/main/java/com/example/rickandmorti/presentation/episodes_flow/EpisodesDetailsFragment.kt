package com.example.rickandmorti.presentation.episodes_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentCharactersDetailsBinding
import com.example.rickandmorti.databinding.FragmentEpisodesDetailsBinding
import com.example.rickandmorti.presentation.character_flow.CharacterDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class EpisodesDetailsFragment : Fragment() {
    private lateinit var binding: FragmentEpisodesDetailsBinding
    val viewModel: EpisodeDetailViewModel by viewModels()
    val args:EpisodesDetailsFragmentArgs by navArgs()

    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadEpisode(args.id)

        viewModel.liveData.observe(viewLifecycleOwner){
            binding.episode.text=it.episode
            binding.tvName.text=it.name
            binding.tvAirDate.text=it.airdate
        }
    }
}