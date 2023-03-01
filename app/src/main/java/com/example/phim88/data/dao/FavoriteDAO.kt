package com.example.phim88.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.phim88.base.BaseDao
import com.example.phim88.data.dto.FavoriteCount
import com.example.phim88.data.entity.Favorite
import com.example.phim88.data.entity.Movie

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Dao
interface FavoriteDAO : BaseDao<Favorite> {
    @Query("SELECT * FROM movies INNER JOIN favorite ON favorite.id_movie = id ORDER BY releaseDate DESC")
    fun getFavoriteMovies(): LiveData<List<Movie>>

//    @Query("SELECT * FROM favorite WHERE id=:idMovie")
//    fun findById(idMovie: Int): LiveData<Movie>

    @Query("SELECT COUNT(*) as favCount FROM favorite WHERE id_movie = :idMovie")
    fun isFavorite(idMovie: Int): LiveData<FavoriteCount>

}