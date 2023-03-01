package com.example.phim88.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.launch

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
abstract class NetworkBoundResource<ResultType, RequestType> constructor(private val contextProviders: ContextProviders) {

    private val result = MediatorLiveData<BaseResponse<ResultType>>()

    init {
        result.value = BaseResponse.loading(null)
        contextProviders.viewModelScopeMain?.launch {
            val dbSource = loadFromDatabase()
            result.addSource(dbSource) { data ->
                result.removeSource(dbSource)
                if (shouldFetch(data)) {
                    fetchFromNetwork(dbSource)
                }
            }
        }
    }

    private fun setValue(newValue: BaseResponse<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dbSource) { newData ->
            setValue(BaseResponse.loading(newData))
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            response.result?.let { requestType ->
                contextProviders.viewModelScopeIO?.launch {
                    saveCallResult(requestType)
                    contextProviders.viewModelScopeMain?.launch {
                        result.addSource(loadFromDatabase()) { newData ->
                            setValue(BaseResponse.success(newData))
                        }
                    }
                }
            }
            response.error?.let {
                onFetchFailed(it)
                contextProviders.viewModelScopeMain?.launch {
                    result.addSource(loadFromDatabase()) { newData ->
                        setValue(BaseResponse.error(it, newData))
                    }
                }
            }
        }

    }
    protected open fun onFetchFailed(error: Exception) {}

    fun asLiveData() = result as LiveData<BaseResponse<ResultType>>

    abstract suspend fun saveCallResult(item: RequestType)

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    abstract fun createCall(): LiveData<BaseResponse<RequestType>>

    protected abstract suspend fun loadFromDatabase(): LiveData<ResultType>

}