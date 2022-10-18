package com.example.rickandmorti.presentation.character_flow

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {
//    private val lastVisibleItemPosition: Int
//        get() = linearLayoutManager.findLastVisibleItemPosition()


    private lateinit var binding: FragmentCharacterListBinding


    val viewModel: CharacterListViewModel by viewModels()
    val adapter by lazy { CharacterListAdapter() }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCharacterList()
        binding.rvCharacterList.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.swipeRefreshCharacter.isRefreshing = false
        }
        binding.swipeRefreshCharacter.setOnRefreshListener {
                viewModel.loadCharacterList()
        }



    }
//
//    private fun setRecyclerViewScrollListener() {
//        binding.rvCharacterList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                val totalItemCount = recyclerView.layoutManager!!.itemCount
//                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
//                    viewModel.loadCharacterList()                }
//            }
//        })
//    }


//    override fun onResume() {
//        super.onResume()
//            viewModel.loadCharacterList()
//            binding.rvCharacterList.adapter = adapter
//            viewModel.liveData.observe(viewLifecycleOwner) {
//                adapter.setList(it)
//                adapter.notifyDataSetChanged()
//            }
//            binding.swipeRefreshCharacter.isRefreshing = false
//        }

//    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
//        val inflater = super.onGetLayoutInflater(savedInstanceState)
//        val contextThemeWrapper: Context = ContextThemeWrapper(requireContext(), R.style.Theme_RickAndMorti)
//        return inflater.cloneInContext(contextThemeWrapper)
//    }
    // }
}