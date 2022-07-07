package com.example.android_aplicaciones.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_aplicaciones.domain.models.Person
import com.example.android_aplicaciones.presentation.components.*
import com.example.android_aplicaciones.presentation.viewmodel.MenuViewModel

class MainActivity : ComponentActivity() {
    val menuViewModel by viewModels<MenuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuViewModel.llenaLaBaseDeDatos(applicationContext)

        setContent {
            val nombre by menuViewModel.nombre.observeAsState("")
            val apellido by menuViewModel.apellido.observeAsState("")
            val dni by menuViewModel.dni.observeAsState("")
            val monto by menuViewModel.monto.observeAsState("")
            val mostrarError by menuViewModel.mostrarError.observeAsState(false)
            val openDialogState = remember { mutableStateOf(false) }
            val listOfCards by menuViewModel.listOfCards.observeAsState(listOf())
            val navController = rememberNavController()
            NavHost(navController, startDestination = Screen.MenuPrincipal.route) {
                composable(Screen.MenuPrincipal.route) {
                    MenuPrincipalPantalla(
                        onClickButtonOne = {
                            navController.navigate(Screen.Registrar.route)
                        },
                        onClickButtonTwo = {
                            navController.navigate(Screen.EstadoDeCuenta.route)
                        },
                        onClickIngresarAlTrenButton = {
                            openDialogState.value = true
                        },
                        onClickDatabaseButton = {
                            navController.navigate(Screen.LineaVerde.route)
                            menuViewModel.getAllTheCards(applicationContext)
                        }
                    )
                    if (openDialogState.value) {
                        IngresarAlTrenDialog(onConfirmButtonClick = {
                            // TODO disminuir el 1.50 el saldo del cliente
                            openDialogState.value = false
                        })
                    }
                }
                composable(Screen.Registrar.route) {
                    RegistroDeTarjetaPantalla(
                        onClickButtonRegistrar = {
                            menuViewModel.registerPerson()
                        },
                        nombre = nombre,
                        apellido = apellido,
                        dni = dni,
                        monto = monto,
                        onValueChangeNombre = {
                            menuViewModel.enviarNombre(it)
                        },
                        onValueChangeApellido = {
                            menuViewModel.enviarApellido(it)
                        },
                        onValueChangeDni = {
                            menuViewModel.enviarDni(it)
                        },
                        onValueChangeMonto = {
                            menuViewModel.enviarMonto(it)
                        }
                    )
                    if (mostrarError) {
                        AlertDialog(onDismissRequest = { /*TODO*/ }, title = {
                            Text("Mensaje de error")
                        }, text = {
                            Text("No se pudo registrar")
                        }, confirmButton = {
                            Button(onClick = {
                                menuViewModel.actualizartMostrarError(false)
                                menuViewModel.enviarNombre("")
                                menuViewModel.enviarApellido("")
                                menuViewModel.enviarDni("")
                                menuViewModel.enviarMonto("")
                                navController.navigate(Screen.MenuPrincipal.route)
                            }, content = {
                                Text("Aceptar")
                            })
                        })
                    }
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
                composable(Screen.LineaVerde.route) {
                    LineaVerdePantalla(listOfCards)
                }
            }
        }
    }
}




