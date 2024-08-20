package com.example.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.data.database.models.Byline
import com.example.data.database.models.Headline
import com.example.data.database.models.Keywords
import com.example.data.database.models.Multimedia
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun fromMultimediaList(value: ArrayList<Multimedia>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Multimedia>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMultimediaList(value: String): ArrayList<Multimedia> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Multimedia>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromKeywordsList(value: ArrayList<Keywords>): String {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Keywords>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toKeywordsList(value: String): ArrayList<Keywords> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Keywords>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromHeadline(value: Headline?): String {
        val gson = Gson()
        val type = object : TypeToken<Headline>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toHeadline(value: String): Headline? {
        val gson = Gson()
        val type = object : TypeToken<Headline>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromByline(value: Byline?): String {
        val gson = Gson()
        val type = object : TypeToken<Byline>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toByline(value: String): Byline? {
        val gson = Gson()
        val type = object : TypeToken<Byline>() {}.type
        return gson.fromJson(value, type)
    }
}