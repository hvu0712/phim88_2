package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.dto.CastDTO
import com.example.phim88.databinding.ItemCastBinding

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class CastAdapter(val onItemClicked: (cast: CastDTO) -> Unit) :
    BaseRecyclerAdapter<CastDTO, ItemCastBinding>(object : DiffUtil.ItemCallback<CastDTO>() {
        override fun areItemsTheSame(oldItem: CastDTO, newItem: CastDTO): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CastDTO, newItem: CastDTO): Boolean =
            oldItem == newItem
    }){
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_cast
    override fun bindFirstTime(binding: ItemCastBinding) {
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