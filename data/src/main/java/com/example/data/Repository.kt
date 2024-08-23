package com.example.data

import com.example.data.database.models.Docs
import com.example.data.network.nytimes.models.MovieReviewsAll


interface Repository {

    suspend fun getReviewesAll(): MovieReviewsAll

    suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAll

    suspend fun getReviewFromDB(id: Int): Docs

    suspend fun insertReviewToDB(doc: Docs)

}

