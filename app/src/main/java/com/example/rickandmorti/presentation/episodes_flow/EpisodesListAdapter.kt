package com.example.rickandmorti.presentation.episodes_flow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EpisodesDomainModel
import com.example.rickandmorti.databinding.ItemEpisodesBinding


class EpisodesListAdapter() :
    RecyclerView.Adapter<EpisodesListAdapter.MyViewHolder>() {
    private var listEpisodes = mutableListOf<EpisodesDomainModel>()
    private lateinit var binding: ItemEpisodesBinding

    class MyViewHolder(private val itemBinding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(episode: EpisodesDomainModel) {
            itemBinding.tvName.text = episode.name
            itemBinding.tvAirDate.text = episode.airdate
            itemBinding.episode.text = episode.episode
            itemBinding.root.setOnClickListener{
                val action = EpisodesListFragmentDirections.actionEpisodesListFragmentToEpisodesDetailsFragment(episode.id)
                itemView.findNavController().navigate(action)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listEpisodes[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return listEpisodes.size
    }

    fun setList(list: List<EpisodesDomainModel>) {
        listEpisodes.clear()
        listEpisodes.addAll(list)
    }

}
