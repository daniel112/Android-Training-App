package com.neudesic.myapplication.di

import com.neudesic.myapplication.domain.network.DadJokeAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

/**
 * Example of setting up multiple injection bindings for the same type
 * ref: https://developer.android.com/training/dependency-injection/hilt-android#inject-provides
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlOther

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlDadJoke

@InstallIn(SingletonComponent::class)
@Module
object NetworkingModule {

    @BaseUrlDadJoke
    @Provides
    fun provideBaseUrlDadJoke(): String {
        return "https://icanhazdadjoke.com"
    }

    /**
     * NOTE: this isn't used, it's just here for an example of
     * multiple injection bindings
     */
    @BaseUrlOther
    @Provides
    fun provideBaseUrlOther(): String {
        return "https://someotherurl.com"
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .build()
    }

    @Provides
    fun provideRetrofitClient(@BaseUrlDadJoke baseUrl: String,
                              okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRestApiService(retrofit: Retrofit): DadJokeAPIService {
        return retrofit.create(DadJokeAPIService::class.java)
    }
}