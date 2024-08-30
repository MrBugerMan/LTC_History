package com.example.data.database.models

import com.example.data.network.nytimes.models.Byline
import com.example.domain.models.BylineDomain
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BylineEntity (

    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("person"       ) var person       : ArrayList<PersonEntity> = arrayListOf(),
    @SerializedName("organization" ) var organization : String?           = null

)

fun BylineEntity.toDomain(): BylineDomain {
    return BylineDomain(
        original = this.original,
        person = ArrayList(this.person.map { it.toDomain() }),
        organization = this.organization
    )
}
