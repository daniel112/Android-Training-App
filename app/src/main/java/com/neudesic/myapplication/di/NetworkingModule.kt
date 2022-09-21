package com.neudesic.myapplication.di

import com.neudesic.module.core.network.CoreNetworkModule
import com.neudesic.module.core.network.CoreNetworkModuleImpl
import com.neudesic.module.core.network.DadJokeAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun provideCoreNetworkModule(): CoreNetworkModule {
        return CoreNetworkModuleImpl()
    }

    @Provides
    fun provideDadJokeApiService(@BaseUrlDadJoke baseUrl: String,
                                 coreNetworkModule: CoreNetworkModule): DadJokeAPIService {
        return coreNetworkModule.getDadJokeAPIService(baseUrl)
    }
}

