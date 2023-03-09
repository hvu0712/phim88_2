package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.phim88.data.dto.MovieDto
import com.example.phim88.data.remote.RemoteDataSource
import io.reactivex.Single

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class MovieByGenresRepository(private val remoteDataSource: RemoteDataSource) {
    private val _isLoading = MediatorLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMoviesByGenres(idGenres: Int, page: Int): Single<MovieDto> {
        return Single.create { emmiter ->
            remoteDataSource.getMoviesByGenre(idGenres, page).subscribe({
                emmiter.onSuccess(it)
                _isLoading.postValue(true)
            }, {
                emmiter.onError(it)
            })
        }
    }
}