package com.neudesic.myapplication.domain.mapper

import com.neudesic.module.core.network.data.dto.DadJokeDTO
import com.neudesic.myapplication.domain.model.DadJoke

interface DadJokeMapperFacade {
    val toDadJoke: (dto: DadJokeDTO) -> DadJoke
    val toDadJokeList: (dtoList: List<DadJokeDTO>) -> List<DadJoke>
}