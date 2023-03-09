package com.example.phim88.view.genres

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentMovieByGenresBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class MovieByGenresFragment : ViewModelBaseFragment<MovieByGenresViewModel, FragmentMovieByGenresBinding>() {
    override val viewModel: MovieByGenresViewModel by viewModel()
    override val getContentViewId: Int = R.layout.fragment_movie_by_genres

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }
}