package com.example.factostan.feature.facts.presentation.models

data class FactUi(
    val text: String,
    val id: String,
    val isSaved: Boolean = false,
)
