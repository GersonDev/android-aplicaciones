package com.example.android_aplicaciones.data.datasources

import com.example.android_aplicaciones.domain.models.Card
import com.example.android_aplicaciones.utils.datastructure.Stack

class MemoryDataSource {

    private val cards: Stack<Card> = Stack()

    init {
        cards.push(Card("A1", 10.00))
        cards.push(Card("A2", 10.00))
        cards.push(Card("A3", 10.00))
        cards.push(Card("A4", 10.00))
        cards.push(Card("A5", 10.00))
        cards.push(Card("A6", 10.00))
        cards.push(Card("A7", 10.00))
        cards.push(Card("A8", 10.00))
        cards.push(Card("A9", 10.00))
    }

    fun popFirstCard(): Card? {
        return cards.pop()
    }

}