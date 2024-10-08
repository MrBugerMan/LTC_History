package com.example.data.network.nytimes.models

import com.example.domain.models.MetaDomain
import com.google.gson.annotations.SerializedName


data class Meta (

  @SerializedName("hits"   ) var hits   : Int? = null,
  @SerializedName("offset" ) var offset : Int? = null,
  @SerializedName("time"   ) var time   : Int? = null

)

fun Meta.toDomain() = MetaDomain(hits, offset, time)

