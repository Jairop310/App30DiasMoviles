package com.example.liverpool.Navegacion

sealed class Router(val route: String){
    object PrimeraVista :Router("PrimeraVista");
    object SegundaVista :Router("SegundaVista");
    object TerceraVista :Router("TerceraVista");
}