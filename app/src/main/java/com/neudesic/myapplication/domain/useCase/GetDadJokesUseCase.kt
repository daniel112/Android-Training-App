package com.neudesic.myapplication.domain.useCase

import com.neudesic.myapplication.data.DadJokeRepository

class GetDadJokesUseCase {
    suspend fun getSingleDadJoke(dadJokeRepository: DadJokeRepository) = dadJokeRepository.getJoke()
}