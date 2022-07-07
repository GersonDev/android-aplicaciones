package com.example.android_aplicaciones.data.datasources

import android.content.Context
import com.example.android_aplicaciones.data.database.LineaUnoDatabase
import com.example.android_aplicaciones.data.database.entities.CardEntity
import com.example.android_aplicaciones.domain.models.Card

class DatabaseDataSource {

    suspend fun getAllTheCards(context: Context): List<Card> {
        val listOfCardEntities = LineaUnoDatabase.buildDatabase(context)
            .cardsDao()
            .getCards()

        return listOfCardEntities.map {
            Card(
                codigo = it.codigo,
                balance = it.balance
            )
        }
    }

    suspend fun insertCard(context: Context, card: Card) {
        val cardEntity = CardEntity(
            codigo = card.codigo,
            balance = card.balance
        )

        LineaUnoDatabase.buildDatabase(context)
            .cardsDao()
            .insertCard(cardEntity)
    }

}