package com.example.liverpool.Navegacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liverpool.Vistas.VistaCategorias
import com.example.liverpool.Vistas.VistaRecomendaciones
import com.example.liverpool.Vistas.VistaSitioEspecifico

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "${Router.PrimeraVista.route}/{param0}") {
        composable(route = "${Router.PrimeraVista.route}/{param0}") { backStackEntry ->
            val param0 = backStackEntry.arguments?.getString("param0")
            VistaCategorias(navController, param0)
        }
        composable(route = "${Router.SegundaVista.route}/{param1}") { backStackEntry ->
            val param1 = backStackEntry.arguments?.getString("param1")
            VistaRecomendaciones(navController, param1)
        }
        composable(route = "${Router.TerceraVista.route}/{param2}") { backStackEntry ->
            val param2 = backStackEntry.arguments?.getString("param2")
            VistaSitioEspecifico(navController, param2)
        }
    }
}

