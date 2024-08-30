package com.example.ltchistory.ui.criticdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.network.CriticName
import com.example.domain.Repository
import com.example.data.network.nytimes.models.MovieReviewsAll
import com.example.domain.models.MovieReviewsAllDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CriticDetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _criticDetails = MutableLiveData<MovieReviewsAllDomain>()
    val criticDetails: LiveData<MovieReviewsAllDomain> get() = _criticDetails

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result =
                repository.getReviewesByCritic("section_name:\"Movies\" AND type_of_material:\"Review\" AND byline:\"${CriticName.criticName}\"")
            withContext(Dispatchers.Main) {
                _criticDetails.value = result
            }
        }
    }

}