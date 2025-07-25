package com.example.factostan.feature.facts.domain

import com.example.factostan.core.domain.DataError
import com.example.factostan.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface FactRepository {
    suspend fun getFacts(): Result<Fact, DataError.Remote>

    fun getRandomFactFromDb(): Flow<Fact?>
    suspend fun insertFact(fact: Fact)
    suspend fun removeFactById(id: String)
    fun getFactsFromDb(): Flow<List<Fact>>
    fun getFactByIdFromDb(id: String): Flow<Fact?>

}