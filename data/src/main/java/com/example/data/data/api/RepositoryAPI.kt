package com.example.data.data.api

import com.example.data.data.api.nytimes.MovieReviewsAPI
import com.example.domain.domain.Repository
import com.example.domain.domain.models.MovieReviewsAll

import javax.inject.Inject


/*class RepositoryAPI @Inject constructor(private val movieReviewsAPI: MovieReviewsAPI) : Repository {

    override suspend fun getReviewes(page: Int): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews(page = page)
        } catch (e: Exception) {
            MovieReviewsAll()
        }
    }
}*/
class RepositoryAPI @Inject constructor(private val movieReviewsAPI: MovieReviewsAPI) : Repository {

    override suspend fun getReviewes(): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews()
        } catch (e: Exception) {
            MovieReviewsAll()
        }
    }
}


