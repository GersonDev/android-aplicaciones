package com.example.android_aplicaciones.domain.repositories

import com.example.android_aplicaciones.domain.models.Person
import com.example.android_aplicaciones.utils.datastructure.Queue

class PersonsRepository {
    private val persons: Queue<Person> = Queue()

    fun addPersonQueue(person:Person){
        persons.enqueue(person)
    }
}