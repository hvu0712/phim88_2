package com.example.phim88.view.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.phim88.data.repository.DetailMovieRepository

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class FavoriteViewModel(
    application: Application,
    private val repository: DetailMovieRepository
) : AndroidViewModel(application) {
    val movies by lazy {
        repository.getFavoriteMovies()
    }
}