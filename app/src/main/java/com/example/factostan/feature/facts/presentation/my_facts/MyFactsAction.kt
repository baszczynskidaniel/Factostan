package com.example.factostan.feature.facts.presentation.my_facts

sealed interface MyFactsAction {
    data class OnRemoveFact(val factId: String): MyFactsAction
    data class OnEditFact(val factId: String): MyFactsAction
}