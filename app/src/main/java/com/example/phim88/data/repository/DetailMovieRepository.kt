package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.data.dao.FavoriteDAO
import com.example.phim88.data.dto.DetailMovieDTO
import com.example.phim88.data.entity.Favorite
import com.example.phim88.data.entity.Movie
import com.example.phim88.data.remote.RemoteDataSource
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class DetailMovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val favoriteDAO: FavoriteDAO
) {
    fun getDetailMovie(idMovie: Int): Single<DetailMovieDTO> = Single.create { emitter ->
        remoteDataSource.getMovieDetail(idMovie).subscribe({
            emitter.onSuccess(it)
        }, {
            emitter.onError(it)
        })
    }
    fun toggleFavoriteMovie(idMovie: Int, isFavorite: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            if (isFavorite) {
                favoriteDAO.delete(Favorite(idMovie=idMovie))
            } else {
                favoriteDAO.save(Favorite(idMovie=idMovie))
            }
        }
    }
    fun getFavoriteMovies(): LiveData<BaseResponse<List<Movie>>> {
        val data = MediatorLiveData<BaseResponse<List<Movie>>>()
        data.value = BaseResponse.loading(null)
        data.addSource(favoriteDAO.getFavoriteMovies()) {
            it?.let {
                data.value = BaseResponse.success(it)
            }
        }
        return data
    }
    fun isFavoriteMovie(movieId: Int): LiveData<Boolean> {
        val isFavorite = MediatorLiveData<Boolean>()
        val favCount = favoriteDAO.isFavorite(movieId)
        isFavorite.addSource(favCount) { data ->
            data?.let {
                isFavorite.value = it.favCount > 0
            }
        }
        return isFavorite
    }
}