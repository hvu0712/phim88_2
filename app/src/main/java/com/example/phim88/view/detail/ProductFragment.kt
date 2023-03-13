package com.example.phim88.view.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentProductBinding
import com.example.phim88.view.adapter.ProducerAdapter
import com.example.phim88.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class ProductFragment : ViewModelBaseFragment<DetailMovieViewModel, FragmentProductBinding>() {
    override val viewModel: DetailMovieViewModel by sharedViewModel(from = { requireParentFragment()!! })

    override val getContentViewId: Int = R.layout.fragment_product

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {
        val producerAdapter = ProducerAdapter()
        recyclerProducer.apply {
            layoutManager = GridLayoutManager(context, 3)
            addItemDecoration(SpaceItemDecoration(context.resources.getDimensionPixelSize(R.dimen.dp_4)))
            this.adapter = producerAdapter
        }
        viewModel.detailMovie.observe(this, Observer {
            it?.let { detail ->
                producerAdapter.submitList(detail.productionCompany)
            }
        })
    }
    companion object {
        @JvmStatic
        fun newInstance() : ProductFragment = ProductFragment()
    }
}