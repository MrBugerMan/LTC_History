package com.example.ltchistory.di

import com.example.data.services.RepositoryAPI
import com.example.domain.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun provideRepositoryAPI(repositoryAPI: RepositoryAPI): Repository
}

