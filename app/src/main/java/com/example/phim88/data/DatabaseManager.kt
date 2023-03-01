package com.example.phim88.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.phim88.BuildConfig
import com.example.phim88.MovieApplication
import com.example.phim88.data.dao.FavoriteDAO
import com.example.phim88.data.dao.GenresDao
import com.example.phim88.data.dao.MovieDao
import com.example.phim88.data.entity.Favorite
import com.example.phim88.data.entity.Genres
import com.example.phim88.data.entity.Movie

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
object DatabaseManager {
    private const val APP_DATABASE_NAME = "moviedb.db"
    val appDatabase by lazy {
        Room.databaseBuilder(MovieApplication.applicationContext!!, AppDatabase::class.java, APP_DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Database(entities = [Genres::class, Movie::class, Favorite::class],
        version = BuildConfig.APP_DATABASE_VERSION, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun genresDao(): GenresDao
        abstract fun movieDao(): MovieDao
        abstract fun favoriteDao(): FavoriteDAO
    }
}