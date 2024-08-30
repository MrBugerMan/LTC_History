package com.example.data.network.nytimes.models

import com.example.domain.models.MovieReviewsAllDomain
import com.google.gson.annotations.SerializedName


data class MovieReviewsAll (
  @SerializedName("status"    ) var status    : String?   = null,
  @SerializedName("copyright" ) var copyright : String?   = null,
  @SerializedName("response"  ) var response  : Response? = Response()

)

fun MovieReviewsAll.toDomain(): MovieReviewsAllDomain {
    return MovieReviewsAllDomain(
        status = this.status,
        copyright = this.copyright,
        response = this.response?.toDomain()
    )
}
