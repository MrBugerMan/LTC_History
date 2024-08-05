package com.example.domain.domain

import com.example.domain.domain.models.MovieReviewsAll


interface Repository {

    suspend fun getReviewesAll(): MovieReviewsAll

    suspend fun getReviewesByCritic(filterQuery: String): MovieReviewsAll
}


// попытка пагинации
/*interface Repository {
    suspend fun getReviewes(page: Int): MovieReviewsAll
}*/