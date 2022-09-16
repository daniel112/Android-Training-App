package com.neudesic.myapplication.domain.repository

import com.neudesic.myapplication.domain.models.DadJoke
import retrofit2.Response

interface DadJokeRepository {
    suspend fun getJoke(): Response<DadJoke>?
}