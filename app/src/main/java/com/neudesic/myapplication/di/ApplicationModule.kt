package com.neudesic.myapplication.di

import com.neudesic.myapplication.data.repository.DadJokeRepositoryImpl
import com.neudesic.myapplication.domain.repository.DadJokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {
    @Provides
    @Singleton
    // how tf does this get called ? magically gets called in the build process
    // name can be anything
    fun providesDadJokeRepo(): DadJokeRepository = DadJokeRepositoryImpl()
}
