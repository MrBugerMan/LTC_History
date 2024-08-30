package com.example.data.database.models

import com.example.data.network.nytimes.models.Legacy
import com.example.domain.models.LegacyDomain
import com.google.gson.annotations.SerializedName


data class LegacyEntity (

  @SerializedName("xlarge"       ) var xlarge       : String? = null,
  @SerializedName("xlargewidth"  ) var xlargewidth  : Int?    = null,
  @SerializedName("xlargeheight" ) var xlargeheight : Int?    = null

)

fun LegacyEntity.toDomain() = LegacyDomain(
  xlarge = this.xlarge,
  xlargewidth = this.xlargewidth,
  xlargeheight = this.xlargeheight
)