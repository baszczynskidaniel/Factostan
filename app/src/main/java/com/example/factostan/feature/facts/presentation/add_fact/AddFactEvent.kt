package com.example.factostan.feature.facts.presentation.add_fact

sealed interface AddFactEvent {
    data object OnAddFact: AddFactEvent
}