package com.example.phim88.data.dto

import android.os.Parcelable
import com.example.phim88.data.entity.Genres
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Parcelize
data class DetailMovieDTO(
    @SerializedName("credits") val credits: CreditsDTO,
    @SerializedName("genres") val genres: List<Genres>,
    @SerializedName("production_companies") val productionCompany: List<ProductionCompany>,
    @SerializedName("videos") val videos: Videos,
    @SerializedName("runtime") val runTime:Int?
) : Parcelable

@Parcelize
data class ProductionCompany(
    val id: Int,
    @SerializedName("logo_path") val logoPath: String,
    val name: String,
    @SerializedName("origin_country") val originCountry: String
) : Parcelable

@Parcelize
data class CreditsDTO(
    @SerializedName("cast") val cast: List<CastDTO>
) : Parcelable

@Parcelize
data class CastDTO(
    @SerializedName("cast_id") val castId: Int,
    val character: String,
    @SerializedName("credit_id") val creditId: String,
    val gender: Int,
    val id: Int,
    val name: String,
    val order: Int,
    @SerializedName("profile_path") val profilePath: String
) : Parcelable

@Parcelize
data class Videos(
    val results: List<TrailerDTO>
) : Parcelable

@Parcelize
data class TrailerDTO(
    val id: String,
    val key: String,
    val name: String
) : Parcelable