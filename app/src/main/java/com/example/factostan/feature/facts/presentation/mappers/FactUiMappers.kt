package com.example.factostan.feature.facts.presentation.mappers

import com.example.factostan.feature.facts.domain.Fact
import com.example.factostan.feature.facts.presentation.models.FactUi

fun FactUi.toFact(): Fact {
    return Fact(
        id = id,
        text = text,
        source = null,
    )
}

fun Fact.toFactUi(): FactUi {
    return FactUi(
        id = id,
        text = text,
        isSaved = true,
    )
}