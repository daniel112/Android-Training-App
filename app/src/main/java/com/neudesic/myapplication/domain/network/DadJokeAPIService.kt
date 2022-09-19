package com.neudesic.myapplication.domain.network

import com.neudesic.myapplication.domain.model.DadJoke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeAPIService {
    @GET("/")
    @Headers("Accept: application/json")
    suspend fun fetchJoke(): Response<DadJoke>
}