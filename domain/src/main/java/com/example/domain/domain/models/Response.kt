package com.example.domain.domain.models

import com.example.domain.domain.models.Docs
import com.example.domain.domain.models.Meta
import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("docs" ) var docs : ArrayList<Docs> = arrayListOf(),
    @SerializedName("meta" ) var meta : Meta?           = Meta()

)