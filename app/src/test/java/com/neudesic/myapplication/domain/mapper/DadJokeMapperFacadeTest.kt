package com.neudesic.myapplication.domain.mapper

import com.google.common.truth.Truth.assertThat
import com.neudesic.module.core.network.data.dto.DadJokeDTO
import com.neudesic.myapplication.domain.model.DadJoke
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DadJokeMapperFacadeTest {

    private val dadJokeMapperFacadeImpl: DadJokeMapperFacadeImpl = DadJokeMapperFacadeImpl()
    private val dadJoke1 = DadJoke("DadJoke1", "Testing Dad Joke 1")
    private val dadJoke2 = DadJoke("DadJoke2", "Testing Dad Joke 2")
    private val dadJoke3 = DadJoke("DadJoke3", "Testing Dad Joke 3")
    private val dadJokeList = listOf(dadJoke1, dadJoke2, dadJoke3)

    @Test
    fun testSingleDadJokes() {
        dadJokeList.forEachIndexed { index, dadJoke ->
            val dadJokeDTO = DadJokeDTO(dadJoke.id, dadJoke.joke)
            val mappedResult = dadJokeMapperFacadeImpl.toDadJoke(dadJokeDTO)
            when (index) {
                0 -> assertThat(mappedResult).isEqualTo(dadJoke1)
                1 -> assertThat(mappedResult).isEqualTo(dadJoke2)
                else -> assertThat(mappedResult).isEqualTo(dadJoke3)
            }
        }
    }

    @Test
    fun testDadJokesList() {
        val dadJokeDTOList: List<DadJokeDTO> = dadJokeList.map { DadJokeDTO(it.id, it.joke) }
        val mappedResult = dadJokeMapperFacadeImpl.toDadJokeList(dadJokeDTOList)
        assertThat(mappedResult).isEqualTo(dadJokeList)
    }
}