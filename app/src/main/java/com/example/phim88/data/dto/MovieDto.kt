package com.example.phim88.data.dto

import com.example.phim88.data.entity.Movie
import com.google.gson.annotations.SerializedName

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
data class MovieDto(@SerializedName("results") val result: List<Movie>)
