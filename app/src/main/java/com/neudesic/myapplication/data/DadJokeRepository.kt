package com.neudesic.myapplication.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.neudesic.myapplication.domain.models.DadJoke
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DadJokeRepository {
    suspend fun getJoke(): LiveData<DadJoke>
}

class DadJokeRepositoryImp : DadJokeRepository {
    override suspend fun getJoke(): LiveData<DadJoke> {
        // TODO: Extract. see https://codersee.com/retrofit-with-kotlin-the-ultimate-guide/
        val retrofit = Retrofit.Builder()
            .baseUrl("https://icanhazdadjoke.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(APIService::class.java)
        val liveData = MutableLiveData<DadJoke>()

        // This dispatcher is optimized to perform disk or network I/O outside of the main thread.
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.fetchJoke()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val item = response.body()
                    println(item)
                    // When data is available, populate LiveData
                    liveData.value = item
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }

        // Synchronously return LiveData
        // Its value will be available onResponse
        return liveData
    }
}

// TODO: Rename
interface APIService {
    // ...

    @GET("/")
    suspend fun fetchJoke(): Response<DadJoke>

    // ...
}