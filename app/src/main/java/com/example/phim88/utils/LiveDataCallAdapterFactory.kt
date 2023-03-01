package com.example.phim88.utils

import androidx.lifecycle.LiveData
import com.example.phim88.base.BaseResponse
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.IllegalArgumentException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
class LiveDataCallAdapterFactory : Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java) {
            return null
        }
        val observableType = getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObserverType = getRawType(observableType)
        when {
            rawObserverType != BaseResponse::class.java -> throw IllegalArgumentException("type must be a resource")
            observableType !is  ParameterizedType -> throw IllegalArgumentException("resource must be parameterized")
            else -> {
                val bodyType = getParameterUpperBound(0, observableType)
                return LiveDataCallAdapter<Any>(bodyType)
            }
        }
    }
}