package com.example.phim88.view.favorite

import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class FavoriteFragment : ViewModelBaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {
    override val viewModel: FavoriteViewModel by viewModel()
    override val getContentViewId: Int = R.layout.fragment_favorite

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }
}