package com.neudesic.module.core.network

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit

interface CoreNetworkModule {
    fun getDadJokeAPIService(baseUrl: String): DadJokeAPIService
}