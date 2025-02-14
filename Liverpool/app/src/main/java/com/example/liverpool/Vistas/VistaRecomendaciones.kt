package com.example.liverpool.Vistas

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.liverpool.Navegacion.Router


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaRecomendaciones(navController: NavController, param1: String? ) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Spacer(modifier = Modifier.width(20.dp))
                Text("Recomendaciones")
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
            },

        )
    },
        content = {
            BodyRec(navController)
        }
    )


}

@Composable
fun BodyRec(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Recomendaciones")
            Button(onClick = {
                navController.navigate(route = Router.TerceraVista.route)
            }) {
                Text("Hola")
            }
        }
    }
}