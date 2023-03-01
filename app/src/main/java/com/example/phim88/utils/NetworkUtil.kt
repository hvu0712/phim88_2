package com.example.phim88.utils

import android.content.Context
import android.net.ConnectivityManager
import com.example.phim88.MovieApplication

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
object NetworkUtil {
    fun isNetworkAvailable(): Boolean {
        val manager = MovieApplication.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return manager.activeNetworkInfo?.isConnected ?: false
    }
}