package com.example.data

import android.util.Log
import com.example.data.database.DaoReviews
import com.example.data.database.models.DocsEntity
import com.example.data.database.models.tDomainy
import com.example.data.network.nytimes.MovieReviewsAPI
import com.example.data.network.nytimes.models.MovieReviewsAll
import com.example.data.network.nytimes.models.toDomain
import com.example.domain.Repository
import com.example.domain.models.DocsDomain
import com.example.domain.models.MovieReviewsAllDomain

import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val daoReviews: DaoReviews,
    private val movieReviewsAPI: MovieReviewsAPI
) : Repository {


    override suspend fun getReviewesAll(): MovieReviewsAllDomain {
        return try {
            movieReviewsAPI.getAllReviews().toDomain()
        } catch (e: Exception) {
            Log.d("RepositoryImpl ERROR", e.toString())
            MovieReviewsAll().toDomain()
        }
    }

    override suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAllDomain {
        return try {
            movieReviewsAPI.getReviewsByCritic(filterQuery = filterQuery).toDomain()
        } catch (e: Exception) {
            Log.d("RepositoryImpl ERROR", e.toString())
            MovieReviewsAll().toDomain()
        }
    }

    override suspend fun getReviewFromDB(id: Int): DocsDomain {
        return daoReviews.loadAllByIds(id).tDomainy()  // .docsDao().loadAllByIds(id)
    }

    /*override suspend fun insertReviewToDB(doc: DocsEntity) {
        return daoReviews.insert(doc)
    }*/


}


