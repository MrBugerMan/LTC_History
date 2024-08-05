package com.example.data.data.api

import android.util.Log
import com.example.data.data.api.nytimes.MovieReviewsAPI
import com.example.domain.domain.Repository
import com.example.domain.domain.models.MovieReviewsAll

import javax.inject.Inject


class RepositoryAPI @Inject constructor(private val movieReviewsAPI: MovieReviewsAPI) : Repository {

    override suspend fun getReviewesAll(): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews()
        } catch (e: Exception) {
            Log.d("RepositoryAPI ERROR", e.toString())
            MovieReviewsAll()
        }
    }

    override suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAll {
        return try {
            movieReviewsAPI.getReviewsByCritic(filterQuery = filterQuery)
        } catch (e: Exception) {
            Log.d("RepositoryAPI ERROR", e.toString())
            MovieReviewsAll()
        }
    }
}

// попытка пагинации
/*class RepositoryAPI @Inject constructor(private val movieReviewsAPI: MovieReviewsAPI) : Repository {

    override suspend fun getReviewes(page: Int): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews(page = page)
        } catch (e: Exception) {
            MovieReviewsAll()
        }
    }
}*/
