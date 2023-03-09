package com.example.phim88.base

import androidx.room.*

@Dao
interface BaseDao<in T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entities: List<T>)

    @Update
    suspend fun update(entity: T)

    @Update
    suspend fun update(entities: List<T>)

    @Delete
    suspend fun delete(entity: T)
}