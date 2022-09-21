package com.neudesic.myapplication.data.repository.dto

import com.google.gson.annotations.SerializedName
import com.neudesic.myapplication.domain.model.DadJoke

sealed interface BaseModel<T> {
    fun toDomain(): T
}
data class DadJokeDTO(
    @SerializedName("id") val id: String,
    @SerializedName("joke") val joke: String
): BaseModel<DadJoke> {
    // TODO: look into mapper from DTO to Domain
    override fun toDomain(): DadJoke = DadJoke(id = this.id, joke = this.joke)
}