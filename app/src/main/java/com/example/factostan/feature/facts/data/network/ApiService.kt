package com.example.factostan.feature.facts.data.network

import com.example.factostan.feature.facts.data.dto.FactDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value = "random")
    suspend fun getFacts(): Response<FactDto>
}