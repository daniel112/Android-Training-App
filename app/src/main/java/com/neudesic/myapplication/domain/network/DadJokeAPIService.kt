package com.neudesic.myapplication.domain.network

import com.neudesic.module.core.network.NetworkResult
import com.neudesic.myapplication.data.repository.dto.DadJokeDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeAPIService {
    @GET("/")
    @Headers("Accept: application/json")
    suspend fun fetchJoke(): NetworkResult<DadJokeDTO>
}