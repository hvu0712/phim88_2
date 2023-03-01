package com.example.phim88.data.repository

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.data.entity.Genres

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
interface HomeContract {
    fun getAllGenres() : LiveData<BaseResponse<List<Genres>>>
}