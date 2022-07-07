package com.example.android_aplicaciones.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardEntity(
    @PrimaryKey var codigo: String,
    @ColumnInfo(name = "balance") var balance: Double
)
