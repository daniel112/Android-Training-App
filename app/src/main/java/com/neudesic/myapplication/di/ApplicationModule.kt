package com.neudesic.myapplication.di

import com.neudesic.module.core.network.DadJokeAPIService
import com.neudesic.myapplication.data.repository.DadJokeRepositoryImpl
import com.neudesic.myapplication.domain.repository.DadJokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApplicationModule {
    @Provides
    @Singleton
    fun providesDadJokeRepo(dadJokeAPIService: DadJokeAPIService): DadJokeRepository {
        return DadJokeRepositoryImpl(dadJokeAPIService)
    }
}
