package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.entity.Movie
import com.example.phim88.databinding.ItemRecyclerCategoryLayoutBinding

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class MovieByGenreAdapter(val onItemClicked: (movie: Movie) -> Unit) :
    BaseRecyclerAdapter<Movie, ItemRecyclerCategoryLayoutBinding>(object :
        DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
            oldItem == newItem
    }) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_recycler_category_layout
    override fun bindFirstTime(binding: ItemRecyclerCategoryLayoutBinding) {
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