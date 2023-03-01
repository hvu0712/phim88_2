package com.example.phim88.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.phim88.base.BaseDao
import com.example.phim88.data.entity.Movie

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Dao
interface MovieDao : BaseDao<Movie> {

    @Query("SELECT * FROM movies")
    fun getAllMovie(): LiveData<List<Movie>>

    @Query("SELECT * FROM movies WHERE query_type=:queryType")
    fun findAllMovieByCategory(queryType: String): LiveData<List<Movie>>
}