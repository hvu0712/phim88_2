package com.example.phim88.di

import com.example.phim88.MovieApplication
import com.example.phim88.data.repository.MovieByCategoryRepository
import com.example.phim88.view.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
val viewModelModule = module {
    single(named(MovieApplication::class.java.name)) {androidApplication()}
    viewModel{ HomeViewModel(get(named(MovieApplication::class.java.name)), get(), get()) }
}