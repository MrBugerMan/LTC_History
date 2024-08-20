package com.example.ltchistory.ui.criticdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.services.CriticName
import com.example.data.Repository
import com.example.data.services.nytimes.models.MovieReviewsAll
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CriticDetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _criticDetails = MutableLiveData<MovieReviewsAll>()
    val criticDetails: LiveData<MovieReviewsAll> get() = _criticDetails

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