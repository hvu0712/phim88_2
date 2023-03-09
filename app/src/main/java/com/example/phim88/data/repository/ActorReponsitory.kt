package com.example.phim88.data.repository

import com.example.phim88.data.dto.ActorDTO
import com.example.phim88.data.dto.MovieDto
import com.example.phim88.data.remote.RemoteDataSource
import io.reactivex.Single

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class ActorReponsitory (private val remoteDataSource: RemoteDataSource) {
    fun getInfoActor(idActor: Int) = Single.create<ActorDTO> {emitter ->
        remoteDataSource.getProfile(idActor).subscribe({
            emitter.onSuccess(it)
        }, {
            emitter.onError(it)
        })
    }
    fun getMovieByActor(idActor: Int, page: Int) = Single.create<MovieDto> {emitter ->
        remoteDataSource.getMoviesByActor(idActor, page).subscribe({
            emitter.onSuccess(it)
        },{
            emitter.onError(it)
        })
    }
}