package com.example.domain.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "MovieReviewsAll")
data class MovieReviewsAll (
  @PrimaryKey(autoGenerate = true) val page: Int,
  //@SerializedName("status"    ) var status    : String?   = null,
  //@SerializedName("copyright" ) var copyright : String?   = null,
  @SerializedName("response"  ) var response  : Response? = Response()

)