package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.entity.Genres
import com.example.phim88.databinding.ItemGenresBinding

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class GenresAdapter(val onItemClicked: (genres: Genres) -> Unit) :
        BaseRecyclerAdapter<Genres, ItemGenresBinding>(object : DiffUtil.ItemCallback<Genres>() {
            override fun areItemsTheSame(oldItem: Genres, newItem: Genres): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Genres, newItem: Genres): Boolean = oldItem == newItem
        }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_genres

    override fun bindFirstTime(binding: ItemGenresBinding) {
        binding.apply {
            buttonName.setOnClickListener{
                item.apply {
                    this?.let {
                        onItemClicked(it)
                    }
                }
            }
        }
    }
}