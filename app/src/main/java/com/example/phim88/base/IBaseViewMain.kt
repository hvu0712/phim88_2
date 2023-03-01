package com.example.phim88.base

import android.os.Bundle
import com.google.android.datatransport.runtime.dagger.BindsInstance

interface IBaseViewMain {
    val getContentViewId: Int
    fun initializeView(savedInstanceState: Bundle?)
    fun initializeComponents()
}