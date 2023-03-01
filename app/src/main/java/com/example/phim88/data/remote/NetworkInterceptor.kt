package com.example.phim88.data.remote

import com.example.phim88.MovieApplication
import com.example.phim88.R
import com.example.phim88.exceptions.NetworkException
import com.example.phim88.utils.NetworkUtil
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class NetworkInterceptor : Interceptor {

    @Throws(NetworkException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isNetworkAvailable()) {
            throw NetworkException(MovieApplication.applicationContext!!.getString(R.string.error_connect))
        }
        return chain.proceed(chain.request())
    }

    companion object {
        fun getInstance() = NetworkInterceptor()
    }
}