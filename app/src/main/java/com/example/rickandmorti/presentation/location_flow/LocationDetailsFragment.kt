package com.example.rickandmorti.presentation.location_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentLocationDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class LocationDetailsFragment : Fragment() {
    private lateinit var binding:FragmentLocationDetailsBinding
     val viewModel:LocationDetailsViewModel by viewModels()
    val args:LocationDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentLocationDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadLocation(args.id)
        viewModel.liveData.observe(viewLifecycleOwner){
            binding.tvName.text=it.name
            binding.tvType.text=it.type
            binding.tvDimension.text=it.dimension
        }
    }
}