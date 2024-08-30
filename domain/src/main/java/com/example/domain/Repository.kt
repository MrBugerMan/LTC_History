package com.example.domain


import com.example.domain.models.DocsDomain
import com.example.domain.models.MovieReviewsAllDomain


interface Repository {

    suspend fun getReviewesAll(): MovieReviewsAllDomain

    suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAllDomain

    suspend fun getReviewFromDB(id: Int): DocsDomain

    //suspend fun insertReviewToDB(doc: DocsDomain)

}

