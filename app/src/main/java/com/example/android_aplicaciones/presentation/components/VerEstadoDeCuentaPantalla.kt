package com.example.android_aplicaciones.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_aplicaciones.domain.models.Card
import com.example.android_aplicaciones.domain.models.Person

@Composable
fun VerEstadoDeCuentaPantalla(persons: List<Person>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        persons.forEach {
            Text("""Usuario: ${it.nombre} - ${it.apellido}
                |Saldo: ${it.card?.balance ?: 0.00}
            """.trimMargin())
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VerEstadoDeCuentaPantallaPreview() {
    VerEstadoDeCuentaPantalla(listOf(
        Person(
            "Carlos",
            "Vargas",
            70871895,
            Card("A0001", 10.00)
        ),
        Person(
            "Gerson",
            "Vargas",
            85412563,
            Card("A0001", 100.00)
        )
    ))
}