package com.example.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BylineDomain (

    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("person"       ) var person       : ArrayList<PersonDomain> = arrayListOf(),
    @SerializedName("organization" ) var organization : String?           = null

)