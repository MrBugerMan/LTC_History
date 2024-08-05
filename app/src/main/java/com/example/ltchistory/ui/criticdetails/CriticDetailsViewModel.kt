package com.example.ltchistory.ui.criticdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.data.api.CriticName
import com.example.domain.domain.Repository
import com.example.domain.domain.models.MovieReviewsAll
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CriticDetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _criticDetails = MutableLiveData<MovieReviewsAll>()
    val criticDetails: LiveData<MovieReviewsAll> get() = _criticDetails

    init {
        viewModelScope.launch {
            repository.getReviewesByCritic("section_name:\"Movies\" AND type_of_material:\"Review\" AND byline:\"${CriticName.criticName}\"")
                .let {
                    _criticDetails.value = it
                }
        }
    }

}