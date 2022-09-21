package com.neudesic.myapplication.di

import com.neudesic.myapplication.domain.facade.DadJokeMapperFacade
import com.neudesic.myapplication.domain.facade.DadJokeMapperFacadeImpl
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