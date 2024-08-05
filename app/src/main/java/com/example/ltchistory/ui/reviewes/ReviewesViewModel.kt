package com.example.ltchistory.ui.reviewes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            repository.getReviewesAll().let { _allReviewes.value = it }
        }
    }


}



// попытка пагинации
/*@HiltViewModel
class ReviewesViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _allReviewes = MutableLiveData<MovieReviewsAll>()
    val allReviewes: LiveData<MovieReviewsAll> get() = _allReviewes

    private var currentPage = 0

    init {
        loadReviewes(currentPage)
    }

    private fun loadReviewes(page: Int) {
        Log.d("page", "currentPage before = $page")
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getReviewes(page)
            withContext(Dispatchers.Main) {
                _allReviewes.value = result
            }
        }
        Log.d("page", "currentPage after = $page")
    }
    *//*private fun loadReviewes(page: Int) {
        Log.d("page", "currentPage = $page")
        viewModelScope.launch {
            repository.getReviewes(page).let {
                _allReviewes.value = it
            }
        }
    }*//*

    fun loadNextPage() {
        currentPage++
        loadReviewes(currentPage)
    }

    fun loadPreviousPage() {
        if (currentPage > 0) {
            currentPage--
            loadReviewes(currentPage)
        }
    }
}*/