package com.example.android_aplicaciones.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_aplicaciones.domain.models.Card
import com.example.android_aplicaciones.domain.models.Person
import com.example.android_aplicaciones.domain.repositories.CardsRepository
import com.example.android_aplicaciones.domain.repositories.PersonsRepository
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {
    private val _nombre = MutableLiveData("")
    val nombre: LiveData<String> = _nombre
    private val _apellido = MutableLiveData("")
    val apellido: LiveData<String> = _apellido
    private val _dni = MutableLiveData("")
    val dni: LiveData<String> = _dni
    private val _monto = MutableLiveData("")
    val monto: LiveData<String> = _monto
    private val _mostrarError = MutableLiveData(false)
    val mostrarError: LiveData<Boolean> = _mostrarError

    private val _listOfCards = MutableLiveData<List<Card>>(listOf())
    val listOfCards: LiveData<List<Card>> = _listOfCards


    private val cardsRepository = CardsRepository()
    private val personsRepository = PersonsRepository()


    fun enviarNombre(nombre: String) {
        _nombre.value = nombre
    }

    fun enviarApellido(apellido: String) {
        _apellido.value = apellido
    }

    fun enviarDni(dni: String) {
        _dni.value = dni
    }

    fun enviarMonto(monto: String) {
        _monto.value = monto
    }

    fun actualizartMostrarError(mostrarError: Boolean) {
        _mostrarError.value = mostrarError
    }

    fun registerPerson() {
        val monto = _monto.value?.toDouble() ?: 0.0
        if (monto >= 10.0) {
            val card = cardsRepository.popFirstCard()
            card?.balance = monto
            val person = Person(
                nombre = _nombre.value ?: "",
                apellido = _apellido.value ?: "",
                dni = _dni.value?.toInt() ?: 0
            )
            person.card = card
            personsRepository.addPersonQueue(person)
        } else {
            _mostrarError.value = true
        }
    }

    fun llenaLaBaseDeDatos(context: Context) {
        viewModelScope.launch {
            cardsRepository.insertCard(context, Card("A1", 10.00))
            cardsRepository.insertCard(context, Card("A2", 10.00))
            cardsRepository.insertCard(context, Card("A3", 10.00))
            cardsRepository.insertCard(context, Card("A4", 10.00))
            cardsRepository.insertCard(context, Card("A5", 10.00))
            cardsRepository.insertCard(context, Card("A6", 10.00))
            cardsRepository.insertCard(context, Card("A7", 10.00))
            cardsRepository.insertCard(context, Card("A8", 10.00))
            cardsRepository.insertCard(context, Card("A9", 10.00))
            cardsRepository.insertCard(context, Card("A10", 10.00))
        }
    }

    fun getAllTheCards(context: Context) {
        viewModelScope.launch {
            _listOfCards.value = cardsRepository.getAllTheCards(context)
        }
    }
}