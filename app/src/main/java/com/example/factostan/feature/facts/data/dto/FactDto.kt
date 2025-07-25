package com.example.factostan.feature.facts.data.dto

import com.google.gson.annotations.SerializedName


data class FactDto(
    @SerializedName("text")
    val text: String,

    @SerializedName("id")
    val id: String,
)
