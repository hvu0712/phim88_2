package com.example.phim88.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

/**
 * Created by Admin on 2/28/2023.
 * @author vup1912@gmail.com
 */
class ContextProviders {
    private val viewModelJob: Job? by lazy { Job() }

    val viewModelScopeMain : CoroutineScope? by lazy {
        CoroutineScope(Dispatchers.IO + viewModelJob as Job)
    }

    val viewModelScopeIO: CoroutineScope? by lazy {
        CoroutineScope(Dispatchers.IO + viewModelJob as Job)
    }

    fun onClear() {
        viewModelScopeMain?.cancel()
        viewModelScopeIO?.cancel()
    }
}