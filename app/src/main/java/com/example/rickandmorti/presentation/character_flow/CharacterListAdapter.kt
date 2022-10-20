package com.example.rickandmorti.presentation.character_flow

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.CharacterDomainModel
import com.example.domain.model.LocationDomainModel
import com.example.rickandmorti.R
import com.example.rickandmorti.databinding.ItemCharacterBinding
import com.example.rickandmorti.paging.Constant

//
class CharacterListAdapter :
    RecyclerView.Adapter<CharacterListAdapter.MyViewHolder>() {
    private var listCharacter = mutableListOf<CharacterDomainModel>()
    private lateinit var binding: ItemCharacterBinding
    lateinit var mcontext: Context


    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class MyViewHolder(private val itemBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(character: CharacterDomainModel) {
            itemBinding.tvName.text = character.name
            itemBinding.tvStatus.text = character.status
            itemBinding.tvSpecies.text = character.species

            Glide
                .with(itemView.context)
                .load(character.imageUrl)
                .into(itemBinding.ivAvatar)
            itemBinding.root.setOnClickListener {
                val action =
                    CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailsFragment(
                        character.id
                    )

                itemView.findNavController()
                    .navigate(action)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listCharacter[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    fun setList(list: List<CharacterDomainModel>) {
             listCharacter.clear()
//        val newLocationList = mutableListOf<CharacterDomainModel>()
//        val diffCallback = DiffCallback(listCharacter, newLocationList)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listCharacter.addAll(list)
//        newLocationList.addAll(list)
        //  diffResult.dispatchUpdatesTo(this)
    }
    override fun getItemViewType(position: Int): Int {
        return if (listCharacter[position] == null) {
            Constant.VIEW_TYPE_LOADING
        } else {
            Constant.VIEW_TYPE_ITEM
        }
    }
    fun addLoadingView() {
        //add loading item
        Handler().post {
           // listCharacter.add(null)
            notifyItemInserted(listCharacter.size - 1)
        }
    }

    fun removeLoadingView() {
        //Remove loading item
        if (listCharacter.size != 0) {
            listCharacter.removeAt(listCharacter.size - 1)
            notifyItemRemoved(listCharacter.size)
        }
    }
}

//
//    class DiffCallback(
//        private val oldList: List<CharacterDomainModel>,
//        private val newList: List<CharacterDomainModel>
//    ) : DiffUtil.Callback() {
//        override fun getOldListSize(): Int = oldList.size
//
//        override fun getNewListSize(): Int = newList.size
//
//        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            val oldLocationModel = oldList[oldItemPosition]
//            val newLocationModel = newList[newItemPosition]
//            return oldLocationModel.id == newLocationModel.id
//        }
//
//        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            val oldLocationModel = oldList[oldItemPosition]
//            val newLocationModel = newList[newItemPosition]
//            return oldLocationModel == newLocationModel
//        }
//    }
//
//}
//class CharacterListAdapter : PagingDataAdapter<CharacterDomainModel,
//        CharacterListAdapter.ImageViewHolder>(diffCallback) {
//
//
//    inner class ImageViewHolder(
//        val binding: CharacterLayoutBinding
//    ) :
//        RecyclerView.ViewHolder(binding.root)
//
//    companion object {
//        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
//            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
//        return ImageViewHolder(
//            CharacterLayoutBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent, false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        val currChar = getItem(position)
//
//        holder.binding.apply {
//
//            holder.itemView.apply {
//                tvDescription.text = "${currChar?.name}"
//
//                val imageLink = currChar?.image
//                imageView.load(imageLink) {
//                    crossfade(true)
//                    crossfade(1000)
//                }
//            }
//        }
//
//    }
//}
//class CharacterListAdapter() :
//    PagingDataAdapter<CharacterDomainModel,CharacterListAdapter.MyViewHolder>(diffCallback) {
//    private var listCharacter = mutableListOf<CharacterDomainModel>()
//    private lateinit var binding: ItemCharacterBinding
//
//
//
//    class MyViewHolder(private val itemBinding: ItemCharacterBinding) :
//        RecyclerView.ViewHolder(itemBinding.root) {
//        companion object {
//        val diffCallback = object : DiffUtil.ItemCallback<CharacterDomainModel>() {
//            override fun areItemsTheSame(oldItem: CharacterDomainModel, newItem: CharacterDomainModel): Boolean {
//                return oldItem.id == newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: CharacterDomainModel, newItem: CharacterDomainModel): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//
//
//        fun bind(character: CharacterDomainModel) {
//            itemBinding.tvName.text = character.name
//            itemBinding.tvStatus.text = character.status
//            itemBinding.tvSpecies.text = character.species
//
//            Glide
//                .with(itemView.context)
//                .load(character.imageUrl)
//                .into(itemBinding.ivAvatar)
//            itemBinding.root.setOnClickListener {
//                val action =
//                    CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailsFragment(
//                        character.id
//                    )
//
//                itemView.findNavController()
//                    .navigate(action)
//            }
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val item = listCharacter[position]
//        holder.bind(item)
//
//    }
//
//    override fun getItemCount(): Int {
//        return listCharacter.size
//    }
//
//    fun setList(list: List<CharacterDomainModel>) {
//        //      listCharacter.clear()
////        val newLocationList = mutableListOf<CharacterDomainModel>()
////        val diffCallback = DiffCallback(listCharacter, newLocationList)
////        val diffResult = DiffUtil.calculateDiff(diffCallback)
//        listCharacter.addAll(list)
////        newLocationList.addAll(list)
//        //  diffResult.dispatchUpdatesTo(this)
//    }
//}
