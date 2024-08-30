package com.example.data.network.nytimes.models

import com.example.data.database.models.DocsEntity
import com.example.data.database.models.tDomainy
import com.example.domain.models.ResponseDomain
import com.google.gson.annotations.SerializedName


data class Response (

    @SerializedName("docs" ) var docs : ArrayList<Docs> = arrayListOf(),
    @SerializedName("meta" ) var meta : Meta?           = Meta()

)

fun Response.toDomain(): ResponseDomain {
    return ResponseDomain(
        docs = ArrayList(this.docs.map { it.toEntity().tDomainy() }),
        meta = this.meta?.toDomain()
    )
}