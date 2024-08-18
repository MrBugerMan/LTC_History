package com.example.data.services

import android.util.Log
import com.example.data.services.nytimes.MovieReviewsAPI
import com.example.domain.domain.Repository
import com.example.domain.domain.models.MovieReviewsAll
import com.example.domain.domain.models.Response

import javax.inject.Inject


class RepositoryAPI @Inject constructor(private val movieReviewsAPI: MovieReviewsAPI) : Repository {

    override suspend fun getReviewesAll(): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews()
        } catch (e: Exception) {
            Log.d("RepositoryAPI ERROR", e.toString())
            MovieReviewsAll(page = -1, response = Response())
        }
    }

    override suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAll {
        return try {
            movieReviewsAPI.getReviewsByCritic(filterQuery = filterQuery)
        } catch (e: Exception) {
            Log.d("RepositoryAPI ERROR", e.toString())
            MovieReviewsAll(page = -1, response = Response())
        }
    }
}


