package com.example.rickandmorti.presentation.character_flow

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CharacterDomainModel
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.FragmentCharacterListBinding
import com.example.rickandmorti.paging.OnLoadMoreListener
import com.example.rickandmorti.paging.RecyclerViewLoadMoreScroll
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {
//    private val lastVisibleItemPosition: Int
//        get() = linearLayoutManager.findLastVisibleItemPosition()


    private lateinit var binding: FragmentCharacterListBinding
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    //val adapter = CharacterListAdapter()

    // lateinit var adapterLinear: CharacterListAdapter
    lateinit var loadMoreItemsCells: List<CharacterDomainModel>


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
//            setRVLayoutManager()
//              setRVScrollListener()
        }
          setAdapter()
        setRVLayoutManager()
        setRVScrollListener()

    }

//    override fun onResume() {
//        super.onResume()
//        binding.rvCharacterList.addOnScrollListener(scrollListener)
//
//    }

    private fun setAdapter() {
        //adapterLinear = CharacterListAdapter()
          //  adapter = CharacterListAdapter()
        adapter.notifyDataSetChanged()
        binding.rvCharacterList.adapter = adapter
    }

    private fun setRVLayoutManager() {
        mLayoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacterList.layoutManager = mLayoutManager
        binding.rvCharacterList.setHasFixedSize(true)
    }

    fun setRVScrollListener() {
        mLayoutManager = LinearLayoutManager(requireContext())
        scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager)
        scrollListener.setOnLoadMoreListener(object :
            OnLoadMoreListener {
            override fun onLoadMore() {
                LoadMoreData()
            }
        })
        binding.rvCharacterList.addOnScrollListener(scrollListener)
    }

    private fun LoadMoreData() {

        //Get the number of the current Items of the main Arraylist
        val start = mLayoutManager.itemCount
        //Load 16 more items
        val end = start + 20
//        //Use Handler if the items are loading too fast.
//        //If you remove it, the data will load so fast that you can't even see the LoadingView
        //   Handler().postDelayed({
        for (i in start..end) {
            //Get data and add them to loadMoreItemsCells ArrayList
            viewModel.loadCharacterByPage(i)
        }

//            //Remove the Loading View
       //     adapter.removeLoadingView()
//            //We adding the data to our main ArrayList
//            adapterLinear.addData(loadMoreItemsCells)
//            //Change the boolean isLoading to false
           scrollListener.setLoaded()
        //Update the recyclerView in the main thread
//            items_linear_rv.post {
      //          adapter.notifyDataSetChanged()
//            }
//        }, 3000)
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
