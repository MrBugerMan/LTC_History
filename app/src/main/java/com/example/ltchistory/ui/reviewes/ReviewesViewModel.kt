package com.example.ltchistory.ui.reviewes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.domain.Repository
import com.example.data.network.nytimes.models.MovieReviewsAll
import com.example.domain.models.MovieReviewsAllDomain
import com.example.domain.usecase.GetAllReviewesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ReviewesViewModel @Inject constructor(private val useCase: GetAllReviewesUseCase) : ViewModel() {

    private val _allReviewes = MutableLiveData<MovieReviewsAllDomain>()
    val allReviewes = _allReviewes

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = useCase.invoke()
            withContext(Dispatchers.Main) {
                _allReviewes.value = result
            }
        }
    }

}
