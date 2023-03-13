package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.dto.TrailerDTO
import com.example.phim88.databinding.ItemTrailerBinding

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class TrailerAdapter(val onItemClicked: (trailer: TrailerDTO) -> Unit) :
    BaseRecyclerAdapter<TrailerDTO, ItemTrailerBinding>(object : DiffUtil.ItemCallback<TrailerDTO>() {
        override fun areItemsTheSame(oldItem: TrailerDTO, newItem: TrailerDTO): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TrailerDTO, newItem: TrailerDTO): Boolean = oldItem == newItem
    }){
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_trailer
    override fun bindFirstTime(binding: ItemTrailerBinding) {
        binding.apply {
            cardView.setOnClickListener {
                item.apply {
                    this?.let {
                        onItemClicked(it)
                    }
                }
            }
        }
    }
}