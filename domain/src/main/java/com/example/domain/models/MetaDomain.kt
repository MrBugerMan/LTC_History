package com.example.domain.models

import com.google.gson.annotations.SerializedName


data class MetaDomain (

  @SerializedName("hits"   ) var hits   : Int? = null,
  @SerializedName("offset" ) var offset : Int? = null,
  @SerializedName("time"   ) var time   : Int? = null

)