package com.example.ltchistory.ui.reviewes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.data.services.nytimes.models.MovieReviewsAll
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReviewesViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _allReviewes = MutableLiveData<MovieReviewsAll>()
    val allReviewes = _allReviewes

    init {
        viewModelScope.launch {
            repository.getReviewesAll().let { _allReviewes.value = it }
        }
    }


}
