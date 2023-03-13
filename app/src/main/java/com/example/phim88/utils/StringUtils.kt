package com.example.phim88.utils

import com.example.phim88.constants.Constants

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
object StringUtils {
    fun getImage(image_path: String) : String {
        val builder = StringBuilder()
        builder.append(Constants.BASE_IMAGE_PATH)
            .append(Constants.IMAGE_SIZE_W500)
            .append(image_path)
        return builder.toString()
    }

    fun getImageW200(image_path: String) : String {
        val builder = StringBuilder()
        builder.append(Constants.BASE_IMAGE_PATH)
            .append(Constants.IMAGE_SIZE_W200)
            .append(image_path)
        return builder.toString()
    }

    fun concateString(vararg strings: String) : String {
        val stringBuilder = StringBuilder()
        for (s in strings) {
            stringBuilder.append(s)
        }
        return stringBuilder.toString()
    }

    fun getThumbnail(trailerKey: String) : String {
        return String.format(Constants.BASE_THUMBNAIL_PATH, trailerKey)
    }

    fun getUrlYoutube(trailerKey: String) : String {
        return String.format(Constants.BASE_YOUTUBE, trailerKey)
    }
}