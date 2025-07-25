package com.example.factostan.feature.facts.presentation.random_facts

import com.example.factostan.feature.facts.presentation.models.FactUi

data class FactsState(
    val fact: FactUi = FactUi("", "", false),
    val isFavourite: Boolean = false,
    val isCopiedToClipboard: Boolean = false,
)