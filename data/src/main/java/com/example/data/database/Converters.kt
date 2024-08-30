package com.example.data.database

import androidx.room.TypeConverter
import com.example.data.database.models.BylineEntity
import com.example.data.database.models.HeadlineEntity
import com.example.data.database.models.KeywordsEntity
import com.example.data.database.models.MultimediaEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun fromMultimediaList(value: ArrayList<MultimediaEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<MultimediaEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMultimediaList(value: String): ArrayList<MultimediaEntity> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<MultimediaEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromKeywordsList(value: ArrayList<KeywordsEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<KeywordsEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toKeywordsList(value: String): ArrayList<KeywordsEntity> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<KeywordsEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromHeadline(value: HeadlineEntity?): String {
        val gson = Gson()
        val type = object : TypeToken<HeadlineEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHeadline(value: String): HeadlineEntity? {
        val gson = Gson()
        val type = object : TypeToken<HeadlineEntity>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromByline(value: BylineEntity?): String {
        val gson = Gson()
        val type = object : TypeToken<BylineEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toByline(value: String): BylineEntity? {
        val gson = Gson()
        val type = object : TypeToken<BylineEntity>() {}.type
        return gson.fromJson(value, type)
    }
}