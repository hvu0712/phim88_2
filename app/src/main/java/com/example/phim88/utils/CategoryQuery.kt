package com.example.phim88.utils

import androidx.annotation.StringDef

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@StringDef(
    CategoryQuery.NOW_PLAYING,
    CategoryQuery.POPULAR,
    CategoryQuery.UP_COMING,
    CategoryQuery.TOP_RATE
)
annotation class CategoryQuery {
    companion object {
        const val NOW_PLAYING = "now_playing"
        const val POPULAR = "popular"
        const val UP_COMING = "upcoming"
        const val TOP_RATE = "top_rated"
    }
}