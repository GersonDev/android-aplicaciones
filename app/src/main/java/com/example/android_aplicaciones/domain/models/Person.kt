package com.example.android_aplicaciones.domain.models

data class Person(
    val nombre: String,
    val apellido: String,
    val dni: Int,
    var card: Card? = null
)