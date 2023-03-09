package com.example.phim88.view.detail

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentProductBinding
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

    }
}