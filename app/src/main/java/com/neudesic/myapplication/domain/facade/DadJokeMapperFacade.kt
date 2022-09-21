package com.neudesic.myapplication.domain.facade

import com.neudesic.module.core.network.data.dto.DadJokeDTO
import com.neudesic.myapplication.domain.model.DadJoke

class DadJokeMapperFacade {
    val toDadJoke: (dto: DadJokeDTO) -> DadJoke = { dto -> DadJoke(dto.id, dto.joke) }
}