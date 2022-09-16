package com.neudesic.myapplication.domain.useCase

import com.neudesic.myapplication.domain.repository.DadJokeRepository
import javax.inject.Inject

class GetDadJokesUseCase @Inject constructor(private val dadJokeRepository: DadJokeRepository) {
    suspend fun getSingleDadJoke() = dadJokeRepository.getJoke()
}