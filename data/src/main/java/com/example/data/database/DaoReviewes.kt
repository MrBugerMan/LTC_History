package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.models.DocsEntity

@Dao
interface DaoReviews {

    @Query("SELECT * FROM docs_database")
    fun getAll(): List<DocsEntity>

    @Query("SELECT * FROM docs_database WHERE id IN (:docIds)")
    fun loadAllByIds(docIds: Int): DocsEntity

    @Query("SELECT COUNT(*) FROM docs_database")
    fun getCount(): Int

    @Insert
    fun insertAll(docsList: List<DocsEntity>)  // vararg docs: DocsEntity

    @Insert
    fun insert(doc: DocsEntity)

    @Delete
    fun delete(doc: DocsEntity)

    @Query("DELETE FROM docs_database")
    fun deleteAll()

}