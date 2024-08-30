package com.example.data.database.models

import com.example.data.network.nytimes.models.Legacy
import com.example.domain.models.MultimediaDomain
import com.google.gson.annotations.SerializedName


data class MultimediaEntity (

    @SerializedName("rank"      ) var rank     : Int?    = null,
    @SerializedName("subtype"   ) var subtype  : String? = null,
    @SerializedName("caption"   ) var caption  : String? = null,
    @SerializedName("credit"    ) var credit   : String? = null,
    @SerializedName("type"      ) var type     : String? = null,
    @SerializedName("url"       ) var url      : String? = null,
    @SerializedName("height"    ) var height   : Int?    = null,
    @SerializedName("width"     ) var width    : Int?    = null,
    @SerializedName("legacy"    ) var legacy   : LegacyEntity? = LegacyEntity(),
    @SerializedName("subType"   ) var subType  : String? = null,
    @SerializedName("crop_name" ) var cropName : String? = null

)

fun MultimediaEntity.toDomain(): MultimediaDomain {
    return MultimediaDomain(
        rank = this.rank,
        subtype = this.subtype,
        caption = this.caption,
        credit = this.credit,
        type = this.type,
        url = this.url,
        height = this.height,
        width = this.width,
        legacy = this.legacy?.toDomain(),
        subType = this.subType,
        cropName = this.cropName
    )
}