package com.neudesic.myapplication.domain.facade

import com.neudesic.module.core.network.data.dto.DadJokeDTO
import com.neudesic.myapplication.domain.model.DadJoke

class DadJokeMapperFacadeImpl() : DadJokeMapperFacade {

    override val toDadJoke: (dto: DadJokeDTO) -> DadJoke = {
        it.toDadJoke()
    }

    override val toDadJokeList: (dtoList: List<DadJokeDTO>) -> List<DadJoke> = {
        it.toDadJokeList()
    }

    private fun DadJokeDTO.toDadJoke(): DadJoke {
        return DadJoke(id, joke)
    }

    private fun List<DadJokeDTO>.toDadJokeList(): List<DadJoke> {
        return map { it.toDadJoke() }
    }

}