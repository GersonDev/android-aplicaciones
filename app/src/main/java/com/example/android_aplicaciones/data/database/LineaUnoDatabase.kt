package com.example.android_aplicaciones.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_aplicaciones.data.database.dao.CardsDao
import com.example.android_aplicaciones.data.database.entities.CardEntity

@Database(entities = [CardEntity::class], version = 1, exportSchema = false)
abstract class LineaUnoDatabase : RoomDatabase() {

    abstract fun cardsDao(): CardsDao

    companion object {

        fun buildDatabase(context: Context): LineaUnoDatabase {
            return Room.databaseBuilder(context, LineaUnoDatabase::class.java, "LineaUnoDatabase")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}