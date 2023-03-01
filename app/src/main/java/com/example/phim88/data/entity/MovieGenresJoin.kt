package com.example.phim88.data.entity

import androidx.room.*

/**
 * Created by Admin on 3/1/2023.
 * @author vup1912@gmail.com
 */
@Entity(indices = [Index(value = ["id_movie", "id_genres"])],
    tableName = "movies_genres_join",
    foreignKeys = [
        ForeignKey(entity = Movie::class,
            parentColumns = ["id"],
            childColumns = ["id_movie"]),
        ForeignKey(entity = Genres::class,
            parentColumns = ["id"],
            childColumns = ["id_genres"])
    ])
data class MovieGenresJoin(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "id_movie")
    val idMovie: Int,
    @ColumnInfo(name = "id_genres")
    val idGenres: Int
)
