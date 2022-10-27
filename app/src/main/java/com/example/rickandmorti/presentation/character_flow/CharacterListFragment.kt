package com.example.rickandmorti.presentation.character_flow


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorti.databinding.FragmentCharacterListBinding
import com.example.rickandmorti.paging.CustomRecyclerViewScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    var TAG ="blabla"
    var currentPage: Int = 1

    private lateinit var binding: FragmentCharacterListBinding


    val viewModel: CharacterListViewModel by viewModels()
    private val adapter by lazy { CharacterListAdapter() }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.loadCharacterList(currentPage)
        binding.rvCharacterList.adapter = adapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacterList.layoutManager =linearLayoutManager
        binding.rvCharacterList.setHasFixedSize(true)

        viewModel.liveData.observe(viewLifecycleOwner) {
            Log.d(TAG, "liveDataChange: size = ${it.size}")
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.swipeRefreshCharacter.isRefreshing = false

        }
        binding.swipeRefreshCharacter.setOnRefreshListener {
            Log.d(TAG, "swipeRefresh: ")
            viewModel.loadCharacterList(currentPage)

        }

        setPagination(linearLayoutManager)

    }

    private fun setPagination(layoutManager: LinearLayoutManager) {
        Log.d(TAG, "setPagination: ")// may be move it to application class
        val scrollListener = object : CustomRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                if (currentPage < viewModel.maxPage!!) {
//
//                }
                viewModel.loadCharacterList(++currentPage)
                Log.d(TAG, "onLoadMore: page = $page, totalItemCount = $totalItemsCount," +
                        "CurrentPage = $currentPage")


            }
        }
        binding.rvCharacterList.addOnScrollListener(scrollListener as CustomRecyclerViewScrollListener)

    }


}

//            locationsRecyclerView.addOnScrollListener(scrollListener as CustomRecyclerViewScrollListener)
//        }
//   //       setAdapter()
////        setRVLayoutManager()
////
////        setRVScrollListener()
//        setRecyclerViewScrollListener()
//
//    }
//
////    private fun setRecyclerViewScrollListener() {
////
////                val totalItemCount = binding.rvCharacterList.layoutManager!!.itemCount
//////                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
//////                    requestPhoto()
//////                }
//////                if ( totalItemCount == lastVisibleItemPosition + 1) {
//////                    viewModel.loadCharacterList(currentPage)
//////                    currentPage++
////
////                    viewModel.loadCharacterList(currentPage)
////                    currentPage++
////
////
////            }
////        })
////    }
//
////    override fun onResume() {
////        super.onResume()
////        binding.rvCharacterList.addOnScrollListener(scrollListener)
////
////    }
////
////    private fun setAdapter() {
////        //adapterLinear = CharacterListAdapter()
////          //  adapter = CharacterListAdapter()
////        adapter.notifyDataSetChanged()
////        binding.rvCharacterList.adapter = adapter
////    }
//

//
////    fun setRVScrollListener() {
////
////
////        mLayoutManager = LinearLayoutManager(requireContext())
////        scrollListener = CustomRecyclerViewScrollListener(mLayoutManager as LinearLayoutManager)
////
////        scrollListener.setOnLoadMoreListener(object :
////            C {
////            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
////                loadMoreData()
////            }
////        })
////
////        binding.rvCharacterList.addOnScrollListener(scrollListener)
////        loadMoreData()
////    }
////
////    private fun loadMoreData() {
////
////        //Get the number of the current Items of the main Arraylist
//        //  val start = adapter.itemCount
//        //Load 16 more items
//        //  val end = start + 20
////        //Use Handler if the items are loading too fast.
////        //If you remove it, the data will load so fast that you can't even see the LoadingView
//        //   Handler().postDelayed({
////        if(currentPage==0||currentPage!=null){
////            currentPage=currentPage+1
////
////            viewModel.loadCharacterList(10)
////            currentPage++
////        }
////
////
////    }
//
//    // for (i in start..end) {
//    //Get data and add them to loadMoreItemsCells ArrayList
//    //viewModel.loadCharacterByPage()
//    // }
//
////            //Remove the Loading View
//    //     adapter.removeLoadingView()
////            //We adding the data to our main ArrayList
////            adapterLinear.addData(loadMoreItemsCells)
////            //Change the boolean isLoading to false
//    //  scrollListener.setLoaded()
//
//    //Update the recyclerView in the main thread
////            items_linear_rv.post {
//    //          adapter.notifyDataSetChanged()
////            }
////        }, 3000)
//
////}
//
////
////    private fun setRecyclerViewScrollListener() {
////        binding.rvCharacterList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
////            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
////                super.onScrollStateChanged(recyclerView, newState)
////                val totalItemCount = recyclerView.layoutManager!!.itemCount
////                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
////                    viewModel.loadCharacterList()                }
////            }
////        })
////    }
//
//
////    override fun onResume() {
////        super.onResume()
////            viewModel.loadCharacterList()
////            binding.rvCharacterList.adapter = adapter
////            viewModel.liveData.observe(viewLifecycleOwner) {
////                adapter.setList(it)
////                adapter.notifyDataSetChanged()
////            }
////            binding.swipeRefreshCharacter.isRefreshing = false
////        }
//
////    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
////        val inflater = super.onGetLayoutInflater(savedInstanceState)
////        val contextThemeWrapper: Context = ContextThemeWrapper(requireContext(), R.style.Theme_RickAndMorti)
////        return inflater.cloneInContext(contextThemeWrapper)
////    }
//// }
