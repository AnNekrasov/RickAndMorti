package com.example.rickandmorti.presentation.location_flow

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EpisodesDomainModel
import com.example.domain.model.LocationDomainModel
import com.example.rickandmorti.databinding.ItemEpisodesBinding
import com.example.rickandmorti.databinding.ItemLocationBinding
import com.example.rickandmorti.presentation.episodes_flow.EpisodesListFragmentDirections


class LocationListAdapter() :
    RecyclerView.Adapter<LocationListAdapter.MyViewHolder>() {
    private var listLocation = mutableListOf<LocationDomainModel>()
    private lateinit var binding: ItemLocationBinding

    class MyViewHolder(private val itemBinding: ItemLocationBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(location: LocationDomainModel) {
            itemBinding.tvName.text = location.name
            itemBinding.dimension.text = location.dimension
            itemBinding.tvType.text = location.type
            itemBinding.root.setOnClickListener {
                val action =
                    LocationListFragmentDirections.actionLocationListFragmentToLocationDetailsFragment(
                        location.id
                    )

                itemView.findNavController().navigate(action)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listLocation[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return listLocation.size
    }

    fun setList(list: List<LocationDomainModel>) {
        val newLocationList = mutableListOf<LocationDomainModel>()
        val diffCallback = DiffCallback(list,newLocationList)
        val diffResult= DiffUtil.calculateDiff(diffCallback)
     //   listLocation.clear()
        listLocation.addAll(list)
        newLocationList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffCallback(
        private val oldList: List<LocationDomainModel>,
        private val newList: List<LocationDomainModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldLocationModel = oldList[oldItemPosition]
            val newLocationModel = newList[newItemPosition]
            return oldLocationModel.id == newLocationModel.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldLocationModel = oldList[oldItemPosition]
            val newLocationModel = newList[newItemPosition]
            return oldLocationModel == newLocationModel
        }
    }
}
