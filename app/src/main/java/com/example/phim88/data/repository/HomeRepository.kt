package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.base.ContextProviders
import com.example.phim88.base.NetworkBoundResource
import com.example.phim88.data.dao.GenresDao
import com.example.phim88.data.dto.GenresDto
import com.example.phim88.data.entity.Genres
import com.example.phim88.data.remote.RemoteDataSource

/**
 * Created by Admin on 2/28/2023.
 * @author vup1912@gmail.com
 */
class HomeRepository(
    val coroutines: ContextProviders,
    private val remoteDataSource: RemoteDataSource,
    private val genresDao: GenresDao
) : HomeContract {
    override fun getAllGenres(): LiveData<BaseResponse<List<Genres>>> {

        return object : NetworkBoundResource<List<Genres>, GenresDto>(coroutines) {
            override suspend fun saveCallResult(item: GenresDto) {
                val genres = item.list
                genresDao.save(genres)
            }

            override fun createCall(): LiveData<BaseResponse<GenresDto>> = remoteDataSource.getGenres()

            override fun shouldFetch(data: List<Genres>?): Boolean = true

            override suspend fun loadFromDatabase(): LiveData<List<Genres>> = genresDao.getAllGenres()

        }.asLiveData()

    }
}