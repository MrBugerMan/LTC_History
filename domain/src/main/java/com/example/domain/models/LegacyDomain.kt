package com.example.domain.models

import com.google.gson.annotations.SerializedName


data class LegacyDomain (

  @SerializedName("xlarge"       ) var xlarge       : String? = null,
  @SerializedName("xlargewidth"  ) var xlargewidth  : Int?    = null,
  @SerializedName("xlargeheight" ) var xlargeheight : Int?    = null

)