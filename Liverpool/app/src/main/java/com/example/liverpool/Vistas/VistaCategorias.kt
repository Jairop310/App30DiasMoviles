package com.example.liverpool.Vistas

import android.annotation.SuppressLint
import android.service.controls.Control
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.liverpool.Clases.Categoria
import com.example.liverpool.Navegacion.AppNavegacion
import com.example.liverpool.Navegacion.Router

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaCategorias(navController: NavController){

        BodyCat(navController)

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyCat(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("LIVERPOOL")
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp)) {
                Main("Category 1", Modifier ,navController)
            }
        }
    )
}

//        Text("Categorias")
//        Button(onClick = {
//            navController.navigate(route = Router.SegundaVista.route)
//        }) {
//            Text("Categoria 1")
//        }
//        Spacer(modifier = Modifier.width(16.dp))






@Composable
fun Main(name: String, modifier: Modifier = Modifier, navController: NavController) {
    val categories = Controlador().obtenerCategorias();
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Categorias",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        categories.forEach { category ->
            CategoryItem(category, navController)
        }
    }
}

@Composable
fun CategoryItem(categoria: Categoria, navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Category Image",
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                navController.navigate("${Router.SegundaVista.route}/Cafeterias")
             }) {
                Text(stringResource(id = categoria.nombre))
            }
        }
    }
}