package com.example.data.services.nytimes.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class MovieReviewsAll (
  @SerializedName("status"    ) var status    : String?   = null,
  @SerializedName("copyright" ) var copyright : String?   = null,
  @SerializedName("response"  ) var response  : Response? = Response()

)