package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.dto.CategoryDTO
import com.example.phim88.data.entity.Movie
import com.example.phim88.databinding.ItemHomeMovieBinding
import com.example.phim88.widget.SpaceItemDecoration

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class HomeAdapter(
    val onMoreClicked: (category: CategoryDTO) -> Unit,
    val onItemClicked: (movie: Movie) -> Unit
) : BaseRecyclerAdapter<CategoryDTO, ItemHomeMovieBinding>(object : DiffUtil.ItemCallback<CategoryDTO>() {
    override fun areContentsTheSame(oldItem: CategoryDTO, newItem: CategoryDTO): Boolean = oldItem == newItem

    override fun areItemsTheSame(oldItem: CategoryDTO, newItem: CategoryDTO): Boolean = oldItem.queryType== newItem.queryType
}) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_home_movie

    override fun bindFirstTime(binding: ItemHomeMovieBinding) {
        val movieHomeAdapter = MovieAdapter { movie ->
            onItemClicked(movie)
        }

        binding.apply {
            recyclerMovie.apply {
                recyclerMovie.apply {
                    addItemDecoration(SpaceItemDecoration(context.resources.getDimensionPixelSize(R.dimen.dp_4)))
                    setHasFixedSize(true)
                    adapter = movieHomeAdapter
                }
                textMore.setOnClickListener {
                    item.apply {
                        this?.let {
                            onMoreClicked(it)
                        }
                    }
                }
            }
        }
    }
}