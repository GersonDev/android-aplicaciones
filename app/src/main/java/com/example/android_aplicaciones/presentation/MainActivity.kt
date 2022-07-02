package com.example.android_aplicaciones.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.compose.composable
import com.example.android_aplicaciones.R
import com.example.android_aplicaciones.domain.models.Person
import com.example.android_aplicaciones.presentation.components.MenuPrincipalPantalla
import com.example.android_aplicaciones.presentation.components.RegistroDeTarjetaPantalla
import com.example.android_aplicaciones.presentation.components.VerEstadoDeCuentaPantalla

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.MenuPrincipal.route) {
                composable(Screen.MenuPrincipal.route) {
                    MenuPrincipalPantalla(
                        {
                            navController.navigate(Screen.Registrar.route)
                        },
                        {
                            navController.navigate(Screen.EstadoDeCuenta.route)
                        }
                    )
                }
                composable(Screen.Registrar.route) {
                    RegistroDeTarjetaPantalla(
                        onClickButtonRegistrar = {
                            navController.navigate(Screen.MenuPrincipal.route)
                        },
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
                composable(Screen.EstadoDeCuenta.route) {
                    VerEstadoDeCuentaPantalla(
                        listOf(
                            Person("Carlitos", "Vargas", 54545454),
                            Person("Gerson", "Vargas", 54545454),
                            Person("Ronaldo", "Vargas", 54545454)
                        )
                    )
                }
            }
        }
    }
}




