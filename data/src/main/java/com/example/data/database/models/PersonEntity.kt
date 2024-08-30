package com.example.data.database.models

import com.example.domain.models.PersonDomain
import com.google.gson.annotations.SerializedName


data class PersonEntity (

  @SerializedName("firstname"    ) var firstname    : String? = null,
  @SerializedName("middlename"   ) var middlename   : String? = null,
  @SerializedName("lastname"     ) var lastname     : String? = null,
  @SerializedName("qualifier"    ) var qualifier    : String? = null,
  @SerializedName("title"        ) var title        : String? = null,
  @SerializedName("role"         ) var role         : String? = null,
  @SerializedName("organization" ) var organization : String? = null,
  @SerializedName("rank"         ) var rank         : Int?    = null

)

fun PersonEntity.toDomain(): PersonDomain {
    return PersonDomain(
        firstname = this.firstname,
        middlename = this.middlename,
        lastname = this.lastname,
        qualifier = this.qualifier,
        title = this.title,
        role = this.role,
        organization = this.organization,
        rank = this.rank
    )
}