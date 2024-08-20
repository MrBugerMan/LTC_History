package com.example.ltchistory.di

import com.example.data.RepositoryImpl
import com.example.data.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun provideRepositoryAPI(repositoryImpl: RepositoryImpl): Repository
}

