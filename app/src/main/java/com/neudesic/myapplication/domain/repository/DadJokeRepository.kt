package com.neudesic.myapplication.domain.repository

import com.neudesic.myapplication.domain.model.DadJoke
import retrofit2.Response

interface DadJokeRepository {
    suspend fun getJoke(): Response<DadJoke>
}