package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.data.dto.CategoryDTO
import com.example.phim88.data.entity.Movie

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
interface MovieDataSource {
    fun getQueryTypeCategory(): List<CategoryDTO>
    fun getMoviesByCategory(queryType: String, page: Int): LiveData<BaseResponse<List<Movie>>>
}
