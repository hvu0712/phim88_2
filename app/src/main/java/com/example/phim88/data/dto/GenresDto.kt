package com.example.phim88.data.dto

import com.example.phim88.data.entity.Genres
import com.google.gson.annotations.SerializedName

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
data class GenresDto(@SerializedName("genres") val list: List<Genres>)
