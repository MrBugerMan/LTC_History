package com.example.domain.models

import com.google.gson.annotations.SerializedName


data class ResponseDomain (

    @SerializedName("docs" ) var docs : ArrayList<DocsDomain> = arrayListOf(),
    @SerializedName("meta" ) var meta : MetaDomain?           = MetaDomain()

)