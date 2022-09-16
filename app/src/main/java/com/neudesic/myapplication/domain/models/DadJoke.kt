package com.neudesic.myapplication.domain.models

import com.google.gson.annotations.SerializedName


data class DadJoke(
    @SerializedName("id") val id: String,
    @SerializedName("joke") val joke: String
    )



/**
 * class vs data class?
 * data class is useful for classes whose main purpose is holding data.
 * Example
 */
//data class DadJoke(val id: Int, val joke: String)
//class DadJokeCls(val id: Int, val joke: String)
//fun main() {
//    val dadjoke = DadJoke(123, "someJoke")
//    val dadjoke2 = DadJoke(123, "someJoke")
//
//    println("dadjoke == dadjoke2? ${dadjoke == dadjoke2}") // True
//
//    val dadjokeCls = DadJokeCls(123, "someJoke")
//    val dadjokeCls2 = DadJokeCls(123, "someJoke")
//
//    println("dadjokeCls == dadjokeCls2? ${dadjokeCls == dadjokeCls2}") // False
//}