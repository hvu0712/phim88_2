package com.example.phim88.view.detail

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class DetailMovieFragment : ViewModelBaseFragment<DetailMovieViewModel, FragmentDetailBinding>() {
    override val viewModel: DetailMovieViewModel by viewModel()

    override val getContentViewId: Int = R.layout.fragment_detail

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }
}