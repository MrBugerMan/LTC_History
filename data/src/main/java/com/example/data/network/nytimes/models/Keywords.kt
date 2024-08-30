package com.example.data.network.nytimes.models

import com.example.data.database.models.KeywordsEntity
import com.google.gson.annotations.SerializedName


data class Keywords (

  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("value" ) var value : String? = null,
  @SerializedName("rank"  ) var rank  : Int?    = null,
  @SerializedName("major" ) var major : String? = null

)

fun Keywords.toEntity(): KeywordsEntity {
  return KeywordsEntity(
    name = this.name,
    value = this.value,
    rank = this.rank,
    major = this.major
  )
}