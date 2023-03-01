package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.base.ContextProviders
import com.example.phim88.base.NetworkBoundResource
import com.example.phim88.data.dao.MovieDao
import com.example.phim88.data.dto.CategoryDTO
import com.example.phim88.data.dto.MovieDto
import com.example.phim88.data.entity.Movie
import com.example.phim88.data.remote.RemoteDataSource
import com.example.phim88.utils.CategoryQuery

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class MovieByCategoryRepository(
    val coroutines: ContextProviders,
    private val remoteDataSource: RemoteDataSource,
    private val movieDao: MovieDao
) : MovieDataSource {
    override fun getQueryTypeCategory() = listOf(
        CategoryDTO(CategoryQuery.POPULAR),
        CategoryDTO(CategoryQuery.UP_COMING)
    )


    override fun getMoviesByCategory(
        queryType: String,
        page: Int
    ): LiveData<BaseResponse<List<Movie>>> = object : NetworkBoundResource<List<Movie>, MovieDto>(coroutines) {
        override suspend fun saveCallResult(item: MovieDto) {
            val movies = item.result
            movies.forEach {
                it.queryType = queryType
            }
            movieDao.save(movies)
        }

        override fun createCall(): LiveData<BaseResponse<MovieDto>> {
            return remoteDataSource.getMoviesByCategory(queryType, page)
        }

        override fun shouldFetch(data: List<Movie>?): Boolean {
            return true
        }

        override suspend fun loadFromDatabase(): LiveData<List<Movie>> {
            return movieDao.findAllMovieByCategory(queryType)
        }
    }.asLiveData()
}