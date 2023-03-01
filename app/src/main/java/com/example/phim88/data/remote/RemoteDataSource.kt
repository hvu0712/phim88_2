package com.example.phim88.data.remote

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.data.dto.ActorDTO
import com.example.phim88.data.dto.DetailMovieDTO
import com.example.phim88.data.dto.GenresDto
import com.example.phim88.data.dto.MovieDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
interface RemoteDataSource {
    @GET("genre/movie/list")
    fun getGenres(): LiveData<BaseResponse<GenresDto>>

    @GET("movie/{type}")
    fun getMoviesByCategory(@Path("type") type: String, @Query("page") page: Int): LiveData<BaseResponse<MovieDto>>

    @GET("discover/movie")
    fun getMoviesByGenre(
        @Query("with_genres") idGenre: Int,
        @Query("page") page: Int
    ): Single<MovieDto>
    @GET("movie/{movie_id}?append_to_response=credits,videos")
    fun getMovieDetail(@Path("movie_id") id: Int): Single<DetailMovieDTO>
    @GET("search/movie")
    fun searchMovieByName(
        @Query("query") key: String,
        @Query("page") page: Int
    ): Single<MovieDto>
    @GET("person/{actor_id}")
    fun getProfile(@Path("actor_id") actorId: Int): Single<ActorDTO>

    @GET("discover/movie")
    fun getMoviesByActor(
        @Query("with_cast") idCast: Int,
        @Query("page") page: Int
    ): Single<MovieDto>
}