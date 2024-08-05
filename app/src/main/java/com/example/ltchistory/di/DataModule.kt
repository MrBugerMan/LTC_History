package com.example.ltchistory.di

import com.example.data.data.api.RepositoryAPI
import com.example.data.data.api.nytimes.MovieReviewsAPI
import com.example.domain.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun provideRepositoryAPI(repositoryAPI: RepositoryAPI): Repository
}

/*
@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    */
/*@Binds
    @Singleton
    fun bindRepositoryAPI(implementation: RepositoryAPI): Repository {
        return implementation
    }*//*


    @Provides
    @Singleton
    fun provideRepositoryAPI(movieReviewsApi: MovieReviewsAPI): RepositoryAPI {
        return RepositoryAPI(movieReviewsApi)
    }

    */
/*@Provides
    @Singleton
    fun provideRepository(repositoryAPI: RepositoryAPI): Repository {
        return repositoryAPI
    }*//*


}
*/
