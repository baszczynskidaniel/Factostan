package com.example.factostan.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FactDao {
    @Query("Select * from fact")
    fun getFacts(): Flow<List<FactEntity>>

    @Query("Delete from fact where id = :id")
    suspend fun removeFactById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(fact: FactEntity)

    @Query("Select * from fact where id = :id")
    fun getFactById(id: String): Flow<FactEntity?>

    @Query("Select * from fact order by random() limit 1")
    fun getRandomFact(): Flow<FactEntity?>
}