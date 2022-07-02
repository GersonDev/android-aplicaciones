package com.example.android_aplicaciones.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import com.example.android_aplicaciones.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
           NavHost(navController, startDestination = Screen.MenuPrincipal.route){

           }
        }
    }
}

    @Composable
    private fun MenuPrincipalPantalla(onClickButtonOne: () -> Unit, onClickButtonTwo: () -> Unit) {
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

