package com.neudesic.myapplication.domain.repository

import com.neudesic.myapplication.domain.model.DadJoke
import com.neudesic.myapplication.domain.network.DataResult

interface DadJokeRepository {
    /**
     * Fetches a joke from remote server or local db
     */
    suspend fun getJoke(): DataResult<DadJoke>
}