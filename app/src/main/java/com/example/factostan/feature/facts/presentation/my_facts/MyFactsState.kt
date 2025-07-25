package com.example.factostan.feature.facts.presentation.my_facts

import com.example.factostan.feature.facts.presentation.models.FactUi

data class MyFactsState(
    val facts: List<FactUi> = emptyList<FactUi>()
)