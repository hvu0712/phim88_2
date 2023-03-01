package com.example.phim88.data.remote

import com.example.phim88.exceptions.ServiceException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class ResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        return validateResponse(response)
    }

    private fun validateResponse(response: Response) : Response {
        if (!response.isSuccessful) {
            throw ServiceException(response.message())
        }
        var responseBody = response.body() ?: return response
        val json = responseBody.string()
        return response.newBuilder()
            .body(ResponseBody.create(responseBody.contentType(), json))
            .build()
    }

    companion object {
        fun getInstance() = ResponseInterceptor()
    }
}