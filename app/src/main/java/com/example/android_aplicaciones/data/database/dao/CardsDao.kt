package com.example.android_aplicaciones.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_aplicaciones.data.database.entities.CardEntity

@Dao
interface CardsDao {

    @Query("SELECT * FROM cards")
    suspend fun getCards(): List<CardEntity>

    @Insert
    suspend fun insertCard(cardEntity: CardEntity)

}