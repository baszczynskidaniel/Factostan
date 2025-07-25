package com.example.factostan.feature.facts.data.mappers

import com.example.factostan.feature.facts.data.dto.FactDto
import com.example.factostan.feature.facts.domain.Fact

fun FactDto.toFact(): Fact {
    return Fact(
        text = text,
        id = id
    )
}

fun Fact.toFactDto(): FactDto {
    return FactDto(
        text = text,
        id = id
    )
}