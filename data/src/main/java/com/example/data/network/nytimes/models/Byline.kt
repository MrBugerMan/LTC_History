package com.example.data.network.nytimes.models

import com.example.data.database.models.BylineEntity
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Byline (

    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("person"       ) var person       : ArrayList<Person> = arrayListOf(),
    @SerializedName("organization" ) var organization : String?           = null

)

fun Byline.toEntity(): BylineEntity {
    return BylineEntity(
        original = this.original,
        person = ArrayList(this.person.map { it.toEntity() }),
        organization = this.organization
    )
}