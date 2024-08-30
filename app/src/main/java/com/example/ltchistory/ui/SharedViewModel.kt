package com.example.ltchistory.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.network.CriticName
import com.example.data.network.nytimes.models.Byline
import com.example.domain.models.BylineDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private val _infoForCritics = MutableLiveData<ArrayList<BylineDomain>>()
    val infoForCritics: LiveData<ArrayList<BylineDomain>> get() = _infoForCritics

    fun setBylines(bylines: ArrayList<BylineDomain>) {
        _infoForCritics.value = bylines
    }


    private val _criticDetails = MutableLiveData<BylineDomain>()
    val criticDetails: LiveData<BylineDomain> get() = _criticDetails

    fun setCriticDetails(byline: BylineDomain) {
        _criticDetails.value = byline

        CriticName.criticName = "${byline.person[0].firstname} ${byline.person[0].lastname}"
    }

}