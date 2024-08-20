package com.example.data

import android.util.Log
import com.example.data.database.DaoReviews
import com.example.data.database.models.Docs
import com.example.data.services.nytimes.MovieReviewsAPI
import com.example.data.services.nytimes.models.MovieReviewsAll

import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val daoReviews: DaoReviews,
    private val movieReviewsAPI: MovieReviewsAPI
) : Repository {


    override suspend fun getReviewesAll(): MovieReviewsAll {
        return try {
            movieReviewsAPI.getAllReviews()
        } catch (e: Exception) {
            Log.d("RepositoryImpl ERROR", e.toString())
            MovieReviewsAll()
        }
    }

    override suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAll {
        return try {
            movieReviewsAPI.getReviewsByCritic(filterQuery = filterQuery)
        } catch (e: Exception) {
            Log.d("RepositoryImpl ERROR", e.toString())
            MovieReviewsAll()
        }
    }

    override suspend fun getReviewFromDB(id: Int): Docs {
        return daoReviews.loadAllByIds(id)  // .docsDao().loadAllByIds(id)
    }

    override suspend fun insertReviewToDB(doc: Docs) {
        return daoReviews.insert(doc)
    }


}


