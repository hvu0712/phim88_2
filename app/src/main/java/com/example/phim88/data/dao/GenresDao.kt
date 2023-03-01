package com.example.phim88.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.phim88.base.BaseDao
import com.example.phim88.data.entity.Genres

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
interface GenresDao : BaseDao<Genres> {

    @Query("SELECT * FROM genres")
    fun getAllGenres(): LiveData<List<Genres>>
}