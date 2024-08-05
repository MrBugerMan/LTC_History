package com.example.domain.domain

import com.example.domain.domain.models.MovieReviewsAll
import javax.inject.Inject


/*interface Repository {
    suspend fun getReviewes(page: Int): MovieReviewsAll
}*/
interface Repository {
    suspend fun getReviewes(): MovieReviewsAll
}
