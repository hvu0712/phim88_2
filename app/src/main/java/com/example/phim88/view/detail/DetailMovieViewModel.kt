package com.example.phim88.view.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.phim88.data.dto.DetailMovieDTO
import com.example.phim88.data.repository.ActorReponsitory
import com.example.phim88.data.repository.DetailMovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class DetailMovieViewModel(
    application: Application,
    private val reponsitory: DetailMovieRepository
) : AndroidViewModel(application){

    private val movieId = MutableLiveData<Int>()
    val detailMovie = MutableLiveData<DetailMovieDTO>()
    val error = MutableLiveData<Throwable>()

    fun initData(movieId: Int) {
        this.movieId.value = movieId
    }

    val isFavorite: LiveData<Boolean> = Transformations.switchMap(movieId) { id ->
        reponsitory.isFavoriteMovie(id)
    }

    fun toggleFavorite(movieId: Int) {
        isFavorite.value?.let {
            reponsitory.toggleFavoriteMovie(movieId, it)
        }
    }

    fun getMovieDetailDto() {
        movieId.value?.let {
            reponsitory.getDetailMovie(it).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ detailMovie.value = it }, { error.value = it })
        }
    }

}