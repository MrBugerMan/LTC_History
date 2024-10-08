package com.example.domain.models

import com.google.gson.annotations.SerializedName


data class KeywordsDomain (

  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("value" ) var value : String? = null,
  @SerializedName("rank"  ) var rank  : Int?    = null,
  @SerializedName("major" ) var major : String? = null

)