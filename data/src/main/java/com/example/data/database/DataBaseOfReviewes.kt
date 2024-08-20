package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.models.Docs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(entities = [Docs::class], version = 1)
@TypeConverters(Converters::class)
abstract class DataBaseOfReviewes: RoomDatabase() {

    abstract fun docsDao(): DaoReviews

    /*companion object {
        @Volatile
        private var INSTANCE: DataBaseOfReviewes? = null

        fun getDatabase(context: Context): DataBaseOfReviewes {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseOfReviewes::class.java,
                    "docs_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBaseOfReviewes(@ApplicationContext appContext: Context): DataBaseOfReviewes {
        return Room.databaseBuilder(
            appContext,
            DataBaseOfReviewes::class.java,
            "docs_database"
        ).build()
    }

    @Provides
    fun provideDocsDao(dataBaseOfReviewes: DataBaseOfReviewes): DaoReviews {
        return dataBaseOfReviewes.docsDao()
    }
}