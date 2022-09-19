package com.neudesic.myapplication.domain.model

import com.google.gson.annotations.SerializedName


data class DadJoke(
    @SerializedName("id") val id: String,
    @SerializedName("joke") val joke: String
    )