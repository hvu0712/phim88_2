package com.example.phim88.view.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import com.example.phim88.data.dto.CategoryDTO
import com.example.phim88.data.entity.Genres
import com.example.phim88.data.entity.Movie
import com.example.phim88.data.repository.HomeRepository
import com.example.phim88.data.repository.MovieByCategoryRepository
import com.example.phim88.utils.CategoryQuery

/**
 * Created by Admin on 2/28/2023.
 * @author vup1912@gmail.com
 */
class HomeViewModel (
    application: Application,
    private val homeRepository: HomeRepository,
    private val repository: MovieByCategoryRepository
        ) : AndroidViewModel(application) {

    private val _genres = homeRepository.getAllGenres()
    val genres: LiveData<BaseResponse<List<Genres>>> = _genres

    companion object {
        private val FIRST_PAGE = 1
    }

    private val _categories by lazy {
        repository.getQueryTypeCategory()
    }

    fun getCategories(): List<CategoryDTO> {
        return _categories
    }

    private val _moviesPopular: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.POPULAR, FIRST_PAGE)
    }

    val moviesPopular: LiveData<BaseResponse<List<Movie>>> = _moviesPopular

    private val _moviesUpComing: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.UP_COMING, FIRST_PAGE)
    }

    val moviesUpComing: LiveData<BaseResponse<List<Movie>>> = _moviesUpComing

    private val _moviesNowPlaying: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.NOW_PLAYING, FIRST_PAGE)
    }

    val moviesNowPlaying: LiveData<BaseResponse<List<Movie>>> = _moviesNowPlaying

    private val _moviesTopRate: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.TOP_RATE, FIRST_PAGE)
    }

    val movieTopRate: LiveData<BaseResponse<List<Movie>>> = _moviesTopRate

    override fun onCleared() {
        super.onCleared()
        homeRepository.coroutines.onClear()
    }
}