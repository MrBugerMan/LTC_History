package com.example.data.services.nytimes.models

import com.google.gson.annotations.SerializedName


data class Legacy (

  @SerializedName("xlarge"       ) var xlarge       : String? = null,
  @SerializedName("xlargewidth"  ) var xlargewidth  : Int?    = null,
  @SerializedName("xlargeheight" ) var xlargeheight : Int?    = null

)