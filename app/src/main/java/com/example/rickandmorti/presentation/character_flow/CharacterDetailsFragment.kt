package com.example.rickandmorti.presentation.character_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentCharacterListBinding
import com.example.rickandmorti.databinding.FragmentCharactersDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CharacterDetailsFragment() : Fragment() {
    private lateinit var binding:FragmentCharactersDetailsBinding
    val viewModel:CharacterDetailsViewModel by viewModels()
    val args:CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =FragmentCharactersDetailsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCharacter(args.id)
        viewModel.liveData.observe(viewLifecycleOwner){
            with(binding){
                tvLocationCharacterDetails.text = it.location.name
                tvName.text=it.name
                tvStatusCharacterDetails.text=it.status

            }

            Glide
                .with(this)
                .load(it.imageUrl)
                .into(binding.ivAvatarCharacterDetails)

        }
    }
}