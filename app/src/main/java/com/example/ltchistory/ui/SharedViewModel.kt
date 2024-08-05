package com.example.ltchistory.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.data.api.CriticName
import com.example.domain.domain.models.Byline
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private val _infoForCritics = MutableLiveData<ArrayList<Byline>>()
    val infoForCritics: LiveData<ArrayList<Byline>> get() = _infoForCritics

    fun setBylines(bylines: ArrayList<Byline>) {
        _infoForCritics.value = bylines
    }


    private val _criticDetails = MutableLiveData<Byline>()
    val criticDetails: LiveData<Byline> get() = _criticDetails

    fun setCriticDetails(byline: Byline) {
        _criticDetails.value = byline

        CriticName.criticName = "${byline.person[0].firstname} ${byline.person[0].lastname}"
    }

}