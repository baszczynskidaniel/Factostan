package com.example.factostan.core.database.mappers

import com.example.factostan.core.database.FactEntity
import com.example.factostan.feature.facts.domain.Fact
import java.util.UUID

fun FactEntity.toFact(): Fact {
    return Fact(
        id = id,
        text = text,
        source = source,
    )
}

fun Fact.toFactEntity(): FactEntity {
    val factId = if(id.isBlank()) UUID.randomUUID().toString() else id
    return FactEntity(
        id = factId,
        text = text,
        source = source,
    )
}