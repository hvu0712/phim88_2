package com.example.phim88.view.search

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.phim88.R
import com.example.phim88.base.ViewModelBaseFragment
import com.example.phim88.databinding.FragmentSearchBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class SearchFragment : ViewModelBaseFragment<SearchViewModel, FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by viewModel()

    override val getContentViewId: Int = R.layout.fragment_search

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }

    @SuppressLint("CheckResult")
    override fun registerListener() {
        super.registerListener()
    }
}