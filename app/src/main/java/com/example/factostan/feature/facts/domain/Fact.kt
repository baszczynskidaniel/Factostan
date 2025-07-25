package com.example.factostan.feature.facts.domain

data class Fact(
    val text: String,
    val id: String,
    val source: String? = null,
)
