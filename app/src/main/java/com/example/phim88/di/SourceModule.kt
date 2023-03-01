package com.example.phim88.di

import com.example.phim88.base.ContextProviders
import com.example.phim88.data.DatabaseManager
import com.example.phim88.data.repository.HomeRepository
import com.example.phim88.data.repository.MovieByCategoryRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
val sourceModule = module {
    single { ContextProviders() }

    single { DatabaseManager.appDatabase.genresDao() }

    single { DatabaseManager.appDatabase.movieDao() }

    single { DatabaseManager.appDatabase.favoriteDao() }

    single { HomeRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }

    single { MovieByCategoryRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }

    single { MovieByGenresRepository(get(named(RemoteProperties.RX_ANDROID))) }

    single { DetailMovieRepository(get(named(RemoteProperties.RX_ANDROID)), get()) }

    single { ActorReponsitory(get(named(RemoteProperties.RX_ANDROID))) }
}