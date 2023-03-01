package com.example.phim88.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey
    @ColumnInfo(name = "id_movie")
    val idMovie: Int
)