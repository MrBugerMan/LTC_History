package com.example.data.services.nytimes.models

import com.example.data.services.nytimes.models.Docs
import com.example.data.services.nytimes.models.Meta
import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("docs" ) var docs : ArrayList<Docs> = arrayListOf(),
    @SerializedName("meta" ) var meta : Meta?           = Meta()

)