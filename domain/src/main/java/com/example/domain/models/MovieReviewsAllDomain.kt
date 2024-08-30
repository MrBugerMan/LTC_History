package com.example.domain.models

import com.google.gson.annotations.SerializedName


data class MovieReviewsAllDomain (
  @SerializedName("status"    ) var status    : String?   = null,
  @SerializedName("copyright" ) var copyright : String?   = null,
  @SerializedName("response"  ) var response  : ResponseDomain? = ResponseDomain()

)