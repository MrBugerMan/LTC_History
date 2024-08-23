package com.example.data.network.nytimes.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Byline (

    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("person"       ) var person       : ArrayList<Person> = arrayListOf(),
    @SerializedName("organization" ) var organization : String?           = null

): Serializable