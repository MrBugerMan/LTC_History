package com.example.data.database.models

import com.example.domain.models.KeywordsDomain
import com.google.gson.annotations.SerializedName


data class KeywordsEntity (

  @SerializedName("name"  ) var name  : String? = null,
  @SerializedName("value" ) var value : String? = null,
  @SerializedName("rank"  ) var rank  : Int?    = null,
  @SerializedName("major" ) var major : String? = null

)

fun KeywordsEntity.toDomain(): KeywordsDomain {
  return KeywordsDomain(
    name = this.name,
    value = this.value,
    rank = this.rank,
    major = this.major
  )
}