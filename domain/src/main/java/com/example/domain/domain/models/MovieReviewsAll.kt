package com.example.domain.domain.models

import com.google.gson.annotations.SerializedName


data class MovieReviewsAll (

  @SerializedName("status"    ) var status    : String?   = null,
  @SerializedName("copyright" ) var copyright : String?   = null,
  @SerializedName("response"  ) var response  : Response? = Response()

)