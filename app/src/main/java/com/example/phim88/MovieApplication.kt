package com.example.phim88

import android.app.Application
import android.content.Context
import com.example.phim88.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(listOf(remoteModule, ))
        }
    }

    companion object {
        lateinit var INSTANCE: MovieApplication
            private set
        val applicationContext: Context?
            get() = if (::INSTANCE.isInitialized) INSTANCE.applicationContext else null
    }
}