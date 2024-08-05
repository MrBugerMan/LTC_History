package com.example.ltchistory.ui.reviewes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.data.api.RepositoryAPI
import com.example.domain.domain.Repository
import com.example.domain.domain.models.MovieReviewsAll
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewesViewModel @Inject constructor(private val repository: Repository): ViewModel() { // private val repository: RepositoryAPI

    private val _allReviewes = MutableLiveData<MovieReviewsAll>()
    val allReviewes = _allReviewes

    init {
        viewModelScope.launch {
            repository.getReviewes().let { _allReviewes.value = it }
            //getReviewes()
        }
    }


    /*// не правильно, это заглушка и тест запроса
    suspend fun getReviewes() {
        _allReviewes.value = com.example.data.data.api.nytimes.MovieReviewsService.retrofitService.getAllReviews(page = 0)
    }*/

}