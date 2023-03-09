package com.example.phim88.view.category

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentMovieByCategoryBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class MovieByCategoryFragment :
    ViewModelBaseFragment<MovieByCategoryViewModel, FragmentMovieByCategoryBinding>() {
    override val viewModel: MovieByCategoryViewModel by viewModel()

    override val getContentViewId: Int = R.layout.fragment_movie_by_category

    override fun initializeView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initializeComponents() {
        TODO("Not yet implemented")
    }
}