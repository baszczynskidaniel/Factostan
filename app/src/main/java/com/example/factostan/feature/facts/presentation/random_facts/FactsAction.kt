package com.example.factostan.feature.facts.presentation.random_facts

sealed interface FactsAction {
    data class OnSaveChange(val factId: String): FactsAction
    data object OnNextFact: FactsAction
    data object OnCopy: FactsAction
}