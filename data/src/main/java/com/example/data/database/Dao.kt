package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.domain.models.MovieReviewsAll

@Dao
interface MovieReviewsAllDao {

    @Query("SELECT * FROM MovieReviewsAll")
    fun getAll(): List<MovieReviewsAll>

    @Query("SELECT * FROM MovieReviewsAll WHERE page IN (:movieReviewsIds)")
    fun loadAllByPage(movieReviewsIds: IntArray): List<MovieReviewsAll>

    @Insert
    fun insertPage(movieReviews: MovieReviewsAll)

    @Query("DELETE FROM MovieReviewsAll")
    fun deleteAll()

}