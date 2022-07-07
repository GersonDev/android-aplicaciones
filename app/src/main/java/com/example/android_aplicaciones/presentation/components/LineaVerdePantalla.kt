package com.example.android_aplicaciones.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_aplicaciones.domain.models.Card

@Composable
fun LineaVerdePantalla(persons: List<Card>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        persons.forEach {
            Text(it.codigo)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ListaVerdePantallaPreview() {
    LineaVerdePantalla(listOf(
        Card(
            "A001",
            20.00
        )
    ))
}