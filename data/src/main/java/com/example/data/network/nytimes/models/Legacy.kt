package com.example.data.network.nytimes.models

import com.example.data.database.models.LegacyEntity
import com.google.gson.annotations.SerializedName


data class Legacy (

  @SerializedName("xlarge"       ) var xlarge       : String? = null,
  @SerializedName("xlargewidth"  ) var xlargewidth  : Int?    = null,
  @SerializedName("xlargeheight" ) var xlargeheight : Int?    = null

)

fun Legacy.toEntity(): LegacyEntity {
  return LegacyEntity(
    xlarge = this.xlarge,
    xlargewidth = this.xlargewidth,
    xlargeheight = this.xlargeheight
  )
}