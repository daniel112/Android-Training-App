package com.neudesic.myapplication.di

import com.neudesic.myapplication.domain.mapper.DadJokeMapperFacade
import com.neudesic.myapplication.domain.mapper.DadJokeMapperFacadeImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MapperFacadeModules {

    @Provides
    fun provideDadJokeMapperFacade(): DadJokeMapperFacade {
        return DadJokeMapperFacadeImpl()
    }
}