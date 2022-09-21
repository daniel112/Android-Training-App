package com.neudesic.module.core.network
import com.neudesic.module.core.network.internal.NetworkResultCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoreNetworkModuleImpl():CoreNetworkModule {
    private val okHttpClient =  OkHttpClient()
        .newBuilder()
        .build()

    /**
     * Set up the Retrofit client with all the boilerplate overrides
     */
    override fun getDadJokeAPIService(baseUrl: String): DadJokeAPIService {
        val client = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResultCallAdapterFactory.create())
            .build()

        return client.create(DadJokeAPIService::class.java)
    }
}

