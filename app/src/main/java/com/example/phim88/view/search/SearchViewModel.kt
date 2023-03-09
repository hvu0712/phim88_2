package com.example.phim88.view.search

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.phim88.data.dto.MovieDto
import com.example.phim88.data.remote.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class SearchViewModel(
    application: Application,
    val remoteDataSource: RemoteDataSource
) : AndroidViewModel(application) {

    private val _movies = MutableLiveData<MovieDto>()
    val movie
        get() = _movies
    private var _error = MutableLiveData<Throwable>()
    val error
        get() = _error

    @SuppressLint("CheckResult")
    fun searchMovie(inputSearch: String) {
        remoteDataSource.searchMovieByName(inputSearch, 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _movies.value = it },{ _error.value = it})
    }
}