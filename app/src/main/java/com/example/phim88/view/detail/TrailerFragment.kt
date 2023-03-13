package com.example.phim88.view.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.data.dto.TrailerDTO
import com.example.phim88.databinding.FragmentProductBinding
import com.example.phim88.view.adapter.TrailerAdapter
import com.example.phim88.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_trailer.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class TrailerFragment : ViewModelBaseFragment<DetailMovieViewModel, FragmentProductBinding>(){
    override val viewModel: DetailMovieViewModel by sharedViewModel(from = { requireParentFragment()!! })

    private lateinit var onTrailerClicked: (trailer: TrailerDTO) -> Unit

    fun setOnTrailerClickListener(onButtonClicked: (trailer: TrailerDTO) -> Unit) {
        this.onTrailerClicked = onButtonClicked
    }
    private lateinit var onFirstTrailer: (trailer: String) -> Unit

    fun setOnFirstTrailerListener(onButtonClicked: (trailer: String) -> Unit) {
        this.onFirstTrailer = onButtonClicked
    }

    override val getContentViewId: Int = R.layout.fragment_trailer

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {
        val castAdapter = TrailerAdapter{
            if (::onTrailerClicked.isInitialized) {
                onTrailerClicked.invoke(it)
            }
        }
        recyclerTrailer.apply {
            layoutManager = GridLayoutManager(context, 3)
            addItemDecoration(SpaceItemDecoration(context.resources.getDimensionPixelSize(R.dimen.dp_4)))
            this.adapter = castAdapter
        }
        viewModel.detailMovie.observe(this, Observer {
            it?.videos?.let { videos ->
                castAdapter.submitList(videos.results)
                if (::onFirstTrailer.isInitialized) onFirstTrailer.invoke(videos.results[0].key)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = TrailerFragment()
    }
}