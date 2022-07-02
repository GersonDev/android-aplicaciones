package com.example.android_aplicaciones.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegistroDeTarjetaPantalla(
    onClickButtonRegistrar: () -> Unit,
    nombre: String,
    apellido: String,
    dni: String,
    monto: String,
    onValueChangeNombre: (String) -> Unit,
    onValueChangeApellido: (String) -> Unit,
    onValueChangeDni: (String) -> Unit,
    onValueChangeMonto: (String) -> Unit
) {

    Column() {
        TextField(
            value = nombre,
            onValueChange = onValueChangeNombre,
            label = {
                Text("Ingrese Nombre:")
            }
        )
        TextField(
            value = apellido,
            onValueChange = onValueChangeApellido,
            label = {
                Text("Ingrese Apellido:")
            }
        )
        TextField(
            value = dni,
            onValueChange = onValueChangeDni,
            label = {
                Text("Ingrese Dni:")
            }
        )
        TextField(
            value = monto,
            onValueChange = onValueChangeMonto,
            label = {
                Text("Ingrese Monto:")
            }
        )
        Button(
            onClick = onClickButtonRegistrar,
            content = {
                Text(
                    "Registrar",
                    color = Color.Green
                )
            })
    }
}

@Preview
@Composable
fun RegistroDeTarjetaPantallaPreview() {
    RegistroDeTarjetaPantalla(onClickButtonRegistrar = {},
        nombre = "",
        apellido = "",
        dni = "",
        monto = "",
        onValueChangeNombre = {},
        onValueChangeApellido = {},
        onValueChangeDni = {},
        onValueChangeMonto = {}
    )
}