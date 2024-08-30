package com.example.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.network.nytimes.models.Docs
import com.example.domain.models.DocsDomain
import com.google.gson.annotations.SerializedName

@Entity(tableName = "docs_database")
data class DocsEntity (
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    @SerializedName("abstract"         ) var abstract       : String?               = null,
    @SerializedName("web_url"          ) var webUrl         : String?               = null,
    @SerializedName("snippet"          ) var snippet        : String?               = null,
    @SerializedName("lead_paragraph"   ) var leadParagraph  : String?               = null,
    @SerializedName("source"           ) var source         : String?               = null,
    @SerializedName("multimedia"       ) var multimedia     : ArrayList<MultimediaEntity> = arrayListOf(),
    @SerializedName("headline"         ) var headline       : HeadlineEntity?             = HeadlineEntity(),
    @SerializedName("keywords"         ) var keywords       : ArrayList<KeywordsEntity>   = arrayListOf(),
    @SerializedName("pub_date"         ) var pubDate        : String?               = null,
    @SerializedName("document_type"    ) var documentType   : String?               = null,
    @SerializedName("news_desk"        ) var newsDesk       : String?               = null,
    @SerializedName("section_name"     ) var sectionName    : String?               = null,
    @SerializedName("byline"           ) var byline         : BylineEntity?         = BylineEntity(),
    @SerializedName("type_of_material" ) var typeOfMaterial : String?               = null,
    @SerializedName("_id"              ) var _id            : String?               = null,
    @SerializedName("word_count"       ) var wordCount      : Int?                  = null,
    @SerializedName("uri"              ) var uri            : String?               = null

)

fun DocsEntity.tDomainy(): DocsDomain {
    return DocsDomain(
        abstract = abstract,
        webUrl = webUrl,
        snippet = snippet,
        leadParagraph = leadParagraph,
        source = source,
        multimedia = ArrayList(this.multimedia.map { it.toDomain() }),
        headline = headline?.toDomain(),
        keywords = ArrayList(this.keywords.map { it.toDomain() }),
        pubDate = pubDate,
        documentType = documentType,
        newsDesk = newsDesk,
        sectionName = sectionName,
        byline = byline?.toDomain(),
        typeOfMaterial = typeOfMaterial,
        _id = _id,
        wordCount = wordCount,
        uri = uri
    )
}