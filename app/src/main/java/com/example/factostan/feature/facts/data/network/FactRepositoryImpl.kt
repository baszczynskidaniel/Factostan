package com.example.factostan.feature.facts.data.network

import com.example.factostan.core.data.safeCall
import com.example.factostan.core.database.FactDao
import com.example.factostan.core.database.mappers.toFact
import com.example.factostan.core.database.mappers.toFactEntity
import com.example.factostan.core.domain.DataError
import com.example.factostan.core.domain.Result
import com.example.factostan.core.domain.map
import com.example.factostan.feature.facts.data.dto.FactDto
import com.example.factostan.feature.facts.data.mappers.toFact
import com.example.factostan.feature.facts.domain.Fact
import com.example.factostan.feature.facts.domain.FactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: FactDao
): FactRepository {
    override suspend fun getFacts(): Result<Fact, DataError.Remote> {
        return safeCall<FactDto> { apiService.getFacts() }
            .map { dto -> dto.toFact() }
    }

    override fun getRandomFactFromDb(): Flow<Fact?> {
        return dao
            .getRandomFact()
            .map { it?.toFact() }
    }



    override suspend fun insertFact(fact: Fact) {

        dao.insertFact(fact.toFactEntity())
    }

    override suspend fun removeFactById(id: String) {
        dao.removeFactById(id)
    }

    override fun getFactsFromDb(): Flow<List<Fact>> {
        return dao.getFacts().map { facts -> facts.map { it.toFact() } }
    }

    override fun getFactByIdFromDb(id: String): Flow<Fact?> {
        return dao.getFactById(id).map { it?.toFact() }
    }


}
