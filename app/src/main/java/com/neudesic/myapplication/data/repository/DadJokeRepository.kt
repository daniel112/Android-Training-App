package com.neudesic.myapplication.data.repository

import com.neudesic.module.core.network.DadJokeAPIService
import com.neudesic.module.core.network.NetworkError
import com.neudesic.module.core.network.NetworkException
import com.neudesic.module.core.network.NetworkSuccess
import com.neudesic.myapplication.domain.model.DadJoke
import com.neudesic.myapplication.domain.model.DataResult
import com.neudesic.myapplication.domain.repository.DadJokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DadJokeRepositoryImpl(private val dadJokeAPIService: DadJokeAPIService) : DadJokeRepository {
    override suspend fun getJoke (): DataResult<DadJoke> {
        return withContext(Dispatchers.IO) {
            // network return obj is abstracted into DataResult
            // so we can keep the model the same if we have a different source for fetching data (like local DB)
            val result = DataResult<DadJoke>()
            when(val response = dadJokeAPIService.fetchJoke()) {
                is NetworkError -> {
                    result.success = false
                    result.message = response.message
                }
                is NetworkException -> {
                    result.success = false
                    result.message = response.e.message ?: "Network Error"
                }
                // TODO: look into mapper from DTO to Domain
                is NetworkSuccess -> result.data = DadJoke.fromDTO(response.data)
            }
            return@withContext result
        }
    }
}

