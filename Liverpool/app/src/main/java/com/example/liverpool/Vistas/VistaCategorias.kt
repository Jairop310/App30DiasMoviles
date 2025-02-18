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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("LIVERPOOL",
                            fontSize = (screenWidth.value * 0.05f).sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFB71C1C))
            )
        },
        containerColor = Color(0xFFFFEBEE),
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).padding(16.dp).fillMaxSize()) {
                Main(Modifier ,navController,screenWidth, screenHeight)
            }
        }
    )
}

@Composable
fun Main(modifier: Modifier = Modifier, navController: NavController,screenWidth: androidx.compose.ui.unit.Dp, screenHeight: androidx.compose.ui.unit.Dp) {
    val categories = Controlador().obtenerCategorias();
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Categorias",
            fontSize = (screenWidth.value * 0.05f).sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        CategoryList(navController,screenWidth,screenHeight)
    }
}

@Composable
fun CategoryList(navController: NavController,screenWidth: androidx.compose.ui.unit.Dp,screenHeight: androidx.compose.ui.unit.Dp) {
    val categories = Controlador().obtenerCategorias();
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = screenWidth * 0.05f)) {
        items(categories) { category ->
            CategoryItem(category, navController,screenWidth)
        }
    }
}

@Composable
fun CategoryItem(categoria: Categoria, navController: NavController,screenWidth: androidx.compose.ui.unit.Dp) {
    val NombreCategotia = stringResource(id = categoria.nombre)
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate("${Router.SegundaVista.route}/${NombreCategotia}") },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = categoria.imagen),
                contentDescription = "Category Image",
                modifier = Modifier.size(screenWidth * 0.15f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(screenWidth * 0.05f))
            Text(
                text = NombreCategotia,
                fontSize = (screenWidth.value * 0.04f).sp,
                color = Color.Black
            )
        }
    }
}
