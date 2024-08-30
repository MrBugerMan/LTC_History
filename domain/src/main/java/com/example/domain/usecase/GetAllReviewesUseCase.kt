package com.example.domain.usecase

import com.example.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetAllReviewesUseCase @Inject constructor(private val repository: Repository) {


    suspend operator fun invoke(filterQuery: String) = repository.getReviewesByCritic(filterQuery)

    suspend operator fun invoke() = repository.getReviewesAll()

}