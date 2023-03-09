package com.example.phim88.view.genres

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.phim88.data.dto.MovieDto
import com.example.phim88.data.repository.MovieByGenresRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class MovieByGenresViewModel(
    application: Application,
    private val repository: MovieByGenresRepository
) : AndroidViewModel(application) {

    private val _movie = MutableLiveData<MovieDto>()
    val movie
        get() = _movie
    private var _error = MutableLiveData<Throwable>()
    val error
        get() = _error
    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading
        get() = _isLoading
    private val _idGenre = MutableLiveData<Int>()

    @SuppressLint("CheckResult")
    fun getMovieByGenres(idGenres: Int) {
        _isLoading.value = true
        repository.getMoviesByGenres(idGenres, FIRST_PAGE).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _movie.value = it
                _isLoading.value = false
            }, {
                _error.value = it
                _isLoading.value = false
            })
    }

    companion object {
        private val FIRST_PAGE = 1
    }
}