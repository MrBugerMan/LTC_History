package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.database.models.Docs

@Dao
interface DaoReviews {

    @Query("SELECT * FROM docs_database")
    fun getAll(): List<Docs>

    @Query("SELECT * FROM docs_database WHERE id IN (:docIds)")
    fun loadAllByIds(docIds: Int): Docs

    @Query("SELECT COUNT(*) FROM docs_database")
    fun getCount(): Int

    @Insert
    fun insertAll(docsList: List<Docs>)  // vararg docs: Docs

    @Insert
    fun insert(doc: Docs)

    @Delete
    fun delete(doc: Docs)

    @Query("DELETE FROM docs_database")
    fun deleteAll()

}