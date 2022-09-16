package com.neudesic.myapplication.data.repository

import com.neudesic.myapplication.domain.repository.DadJokeRepository
import com.neudesic.myapplication.domain.models.DadJoke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.lang.Exception


class DadJokeRepositoryImpl : DadJokeRepository {
    override suspend fun getJoke(): Response<DadJoke>? {
        // TODO: Extract. see https://codersee.com/retrofit-with-kotlin-the-ultimate-guide/
        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)

        return withContext(Dispatchers.IO) {
            try {
                return@withContext service.fetchJoke()
            }catch (error: Exception) {
                println(error)
                return@withContext null
            }
        }
        // This dispatcher is optimized to perform disk or network I/O outside of the main thread.
//        CoroutineScope(Dispatchers.IO).launch {
//
//            // Do the GET request and get response
//            val response = service.fetchJoke()
//            withContext(Dispatchers.Main) {
//                if (response.isSuccessful) {
//                    val item = response.body()
//                    println(item)
//                    // When data is available, populate LiveData
//                    liveData.value = item
//                } else {
//                    Log.e("RETROFIT_ERROR", response.code().toString())
//                }
//            }
//        }
//
//        // Synchronously return LiveData
//        // Its value will be available onResponse
//        return liveData
    }
}

// TODO: Rename
interface APIService {
    // ...

    @GET("/")
    @Headers("Accept: application/json")
    suspend fun fetchJoke(): Response<DadJoke>

    // ...
}