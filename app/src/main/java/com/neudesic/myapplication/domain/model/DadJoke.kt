package com.neudesic.myapplication.domain.model

import com.neudesic.module.core.network.data.dto.DadJokeDTO

sealed interface DataMapper<I, O> {
    fun fromDTO(dto:O): I
}

data class DadJoke(
    val id: String,
    val joke: String
    ) {
    // TODO: remove, just trying things out
    companion object: DataMapper<DadJoke, DadJokeDTO> {
        override fun fromDTO(dto: DadJokeDTO): DadJoke {
            return DadJoke(dto.id, dto.joke)
        }
    }

}

//interface Mapper<I, O> {
//    fun map(input: I): O
//}
//interface ListMapper<I, O>: Mapper<List<I>, List<O>>
//// Non-nullable to Non-nullable
//inline fun <I, O> mapList(input: List<I>, mapSingle: (I) -> O): List<O> {
//    return input.map { mapSingle(it) }
//}
//
//// Nullable to Non-nullable
//inline fun <I, O> mapNullInputList(input: List<I>?, mapSingle: (I) -> O): List<O> {
//    return input?.map { mapSingle(it) } ?: emptyList()
//}
//
//// Non-nullable to Nullable
//inline fun <I, O> mapNullOutputList(input: List<I>, mapSingle: (I) -> O): List<O>? {
//    return if (input.isEmpty()) null else input.map { mapSingle(it) }
//}


