package com.example.phim88.data.dto

import com.example.phim88.data.entity.Movie

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
data class CategoryDTO(val queryType: String, var movies: List<Movie> = emptyList())