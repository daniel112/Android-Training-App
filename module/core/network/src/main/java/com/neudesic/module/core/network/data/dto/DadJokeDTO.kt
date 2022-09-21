package com.neudesic.module.core.network.data.dto

import com.google.gson.annotations.SerializedName


data class DadJokeDTO(
    @SerializedName("id") val id: String,
    @SerializedName("joke") val joke: String
)