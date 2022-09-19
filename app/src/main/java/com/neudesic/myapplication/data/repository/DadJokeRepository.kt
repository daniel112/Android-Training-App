package com.neudesic.myapplication.data.repository

import com.neudesic.myapplication.domain.repository.DadJokeRepository
import com.neudesic.myapplication.domain.model.DadJoke
import com.neudesic.myapplication.domain.network.DadJokeAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DadJokeRepositoryImpl(private val dadJokeAPIService: DadJokeAPIService) : DadJokeRepository {
    override suspend fun getJoke (): Response<DadJoke> {
        return withContext(Dispatchers.IO) {
            return@withContext dadJokeAPIService.fetchJoke()
        }
    }
}