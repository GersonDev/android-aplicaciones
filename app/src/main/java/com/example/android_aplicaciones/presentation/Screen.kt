package com.example.android_aplicaciones.presentation

sealed class Screen(val route:String){
    object  MenuPrincipal:Screen("menuPrincipalPantalla")
    object Registrar:Screen("registrarPantalla")
    object EstadoDeCuenta:Screen("estadoDeCuenta")
}
