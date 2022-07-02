package com.example.android_aplicaciones.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_aplicaciones.R

@Composable
fun MenuPrincipalPantalla(onClickButtonOne: () -> Unit, onClickButtonTwo: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.metro1),
            contentDescription = "Logo Linea1"
        )
        Button(onClick = onClickButtonOne, content = {
            Text("Venta de Tarjetas")
        })
        Button(onClick = onClickButtonTwo, content = {
            Text("Ver estado de Cuentas")
        })
        /*Button(onClick = {}, content = {
            Text("Escanear tarjetas para ingresar al tren")
        })
        Button(onClick = {}, content = {
            Text("Recargar Tarjeta")
        })*/
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPrincipalPreview() {
    MenuPrincipalPantalla(onClickButtonOne = { /*TODO*/ }, onClickButtonTwo = {})
}