package com.example.data.services.nytimes.models

import com.google.gson.annotations.SerializedName


data class Meta (

  @SerializedName("hits"   ) var hits   : Int? = null,
  @SerializedName("offset" ) var offset : Int? = null,
  @SerializedName("time"   ) var time   : Int? = null

)