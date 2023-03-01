package com.example.phim88.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Entity(tableName = "movies", primaryKeys = ["id"])
@Parcelize
data class Movie(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_count")
    val voteCount: Int?,
    @SerializedName("vote_average")
    val voteAverage: Float?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("release_date")
    val releaseDate:String
): Parcelable {
    @ColumnInfo(name = "query_type")
    var queryType: String = ""
}
