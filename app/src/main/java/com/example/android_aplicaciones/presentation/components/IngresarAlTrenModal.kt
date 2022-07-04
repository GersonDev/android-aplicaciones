package com.example.android_aplicaciones.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_aplicaciones.ui.theme.AndroidaplicacionesTheme

@Composable
fun IngresarAlTrenDialog(onConfirmButtonClick: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            Button(onClick = onConfirmButtonClick, content = {
                Text("Aceptar")
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta))
        },
        title = {
            Text("Ingresar al tren")
        },
        text = {
            Column {
                Text("El costo por ingreso es S/ 1.50")
                TextField(
                    value = "tajeta",
                    onValueChange = {},
                    label = {
                        Text("Haga swipe o coloque su tarjeta(codigo)")
                    }
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun IngresarAlTrenDialogPreview() {
    AndroidaplicacionesTheme {
        val muta = remember { mutableStateOf(false) }
        IngresarAlTrenDialog({
        })
    }
}