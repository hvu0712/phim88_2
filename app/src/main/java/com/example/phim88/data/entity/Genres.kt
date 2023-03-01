package com.example.phim88.data.entity

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Entity(tableName = "genres", primaryKeys = ["id"])
@Parcelize
data class Genres(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
):Parcelable