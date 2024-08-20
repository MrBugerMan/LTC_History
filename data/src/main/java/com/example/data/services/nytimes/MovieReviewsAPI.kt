package com.example.data.services.nytimes

import com.example.data.services.nytimes.models.MovieReviewsAll
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


interface MovieReviewsAPI {

    // https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=section_name%3A"Movies" AND type_of_material%3A"Review"&sort=newest&page=0&api-key=YOUR_API_KEY
    @GET("svc/search/v2/articlesearch.json")
    suspend fun getAllReviews(
        @Query("fq") filterQuery: String = "section_name:\"Movies\" AND type_of_material:\"Review\"",
        @Query("sort") sort: String = "newest",
        @Query("page") page: Int = 0,
        @Query("api-key") apiKey: String = MovieReviewsAPItools.API_KEY
    ): MovieReviewsAll

    // https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=section_name%3A"Movies" AND type_of_material%3A"Review" AND byline%3A"Amy%20Nicholson"&sort=newest&page=0&api-key=YOUR_API_KEY
    @GET("svc/search/v2/articlesearch.json")
    suspend fun getReviewsByCritic(
        @Query("fq") filterQuery: String = "section_name:\"Movies\" AND type_of_material:\"Review\" AND byline:\"Beandrea July\"",
        @Query("sort") sort: String = "newest",
        @Query("page") page: Int = 0,
        @Query("api-key") apiKey: String = MovieReviewsAPItools.API_KEY
    ): MovieReviewsAll

}




@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideMovieReviewsAPI(): MovieReviewsAPI {
        return Retrofit.Builder()
            .baseUrl(MovieReviewsAPItools.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MovieReviewsAPI::class.java)
    }

}




