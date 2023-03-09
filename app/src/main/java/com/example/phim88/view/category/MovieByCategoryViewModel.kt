package com.example.phim88.view.category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.phim88.data.repository.MovieByCategoryRepository
import com.example.phim88.utils.CategoryQuery

/**
 * Created by Admin on 3/9/2023.
 * @author vup1912@gmail.com
 */
class MovieByCategoryViewModel(
    application: Application,
    private val repository: MovieByCategoryRepository
) : AndroidViewModel(application) {

    private val _queryType = MutableLiveData<String>()
    val queryType: LiveData<String>
        get() = _queryType

    val movie = Transformations.switchMap(_queryType) {
        it?.let {
            repository.getMoviesByCategory(queryType = it, page = FIRST_PAGE)
        }
    }

    fun initQueryType(query: String?) {
        query?.let {
            _queryType.value = it
        }
    }

    companion object {
        private val FIRST_PAGE = 1
    }
}