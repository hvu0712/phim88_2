package com.example.phim88.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RoomWarnings
import com.example.phim88.base.BaseDao
import com.example.phim88.data.entity.Genres
import com.example.phim88.data.entity.Movie
import com.example.phim88.data.entity.MovieGenresJoin

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Dao
interface MovieGenresJoinDao : BaseDao<MovieGenresJoin> {
    @Query(
        """SELECT * FROM movies INNER JOIN movies_genres_join ON
            movies.id=movies_genres_join.id_movie WHERE
            movies_genres_join.id_genres=:idGenres"""
    )
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    fun getMovieForGenres(idGenres: Int): List<Movie>

    @Query(
        """SELECT * FROM genres INNER JOIN movies_genres_join ON
            genres.id=movies_genres_join.id_genres WHERE
            movies_genres_join.id_movie=:idMovie"""
    )
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    fun getRepositoriesForUsers(idMovie: Int): List<Genres>

}