package com.example.phim88.utils

import android.os.Build
import com.example.phim88.BuildConfig
import com.example.phim88.MovieApplication
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
object DeviceUtil {
    fun getVersionApp() : String {
        return BuildConfig.VERSION_NAME
    }

    fun getVersionData() : String {
        return BuildConfig.APP_DATABASE_VERSION.toString()
    }

    fun getBuildTime(pattern: String) : String {
        val locale = MovieApplication.applicationContext!!.resources.configuration.locale
        val simpleDateFormat = SimpleDateFormat(pattern, locale)
        return simpleDateFormat.format(Date(BuildConfig.BUILD_TIME))
    }
}