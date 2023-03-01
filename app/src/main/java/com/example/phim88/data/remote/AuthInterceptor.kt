package com.example.phim88.data.remote

import com.example.phim88.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest
            .newBuilder()
            .url(originalRequest.url()
                .newBuilder()
                .addQueryParameter(QUERRY_PARAMETER_API_KEY, API_KEY)
                .build()).build()
        return chain.proceed(newRequest)
    }

    companion object {
        const val QUERRY_PARAMETER_API_KEY = "api_key"
        const val API_KEY = BuildConfig.CLIENT_ID
        fun getInstance() = AuthInterceptor()
    }
}