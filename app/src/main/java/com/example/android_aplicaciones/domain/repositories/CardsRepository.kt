package com.example.android_aplicaciones.domain.repositories

import android.content.Context
import com.example.android_aplicaciones.data.datasources.DatabaseDataSource
import com.example.android_aplicaciones.data.datasources.MemoryDataSource
import com.example.android_aplicaciones.domain.models.Card
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CardsRepository {

    private val memoryDataSource = MemoryDataSource()
    private val databaseDataSource = DatabaseDataSource()

    fun popFirstCard(): Card? {
        return memoryDataSource.popFirstCard()
    }

    suspend fun getAllTheCards(context: Context): List<Card> {
        return withContext(Dispatchers.IO) {
            databaseDataSource.getAllTheCards(context)
        }
    }

    suspend fun insertCard(context: Context, card: Card) {
        return withContext(Dispatchers.IO) {
            databaseDataSource.insertCard(context, card)
        }
    }

}