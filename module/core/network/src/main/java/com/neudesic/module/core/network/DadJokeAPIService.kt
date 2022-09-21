package com.neudesic.module.core.network

import com.neudesic.module.core.network.data.dto.DadJokeDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeAPIService {
    @GET("/")
    @Headers("Accept: application/json")
    suspend fun fetchJoke(): NetworkResult<DadJokeDTO>
}