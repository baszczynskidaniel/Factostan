package com.example.factostan.feature.facts.presentation.add_fact

sealed interface AddFactAction {
    data class OnTextChange(val text: String): AddFactAction
    data object OnAddFact: AddFactAction
    data object OnClearText: AddFactAction
}