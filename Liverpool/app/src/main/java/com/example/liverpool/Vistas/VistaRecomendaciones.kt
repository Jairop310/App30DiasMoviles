package com.example.liverpool.Vistas

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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
import com.example.liverpool.Clases.Recomendacion
import com.example.liverpool.Navegacion.Router
import com.example.liverpool.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaRecomendaciones(navController: NavController, param1: String? ) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val textSize = (screenWidth.value * 0.05f).sp
    val categories = Controlador().obtenerCategorias()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.recomendaciones), fontSize = textSize, color = Color.White)
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.volver),
                        modifier = Modifier
                            .size(screenWidth * 0.07f)
                            .clickable { navController.popBackStack() },
                        tint = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFB71C1C))
            )
        },
        containerColor = Color(0xFFFFEBEE),
        content = { paddingValues ->
            val category = categories.find { stringResource(id = it.nombre) == param1 }
            if (category != null) {
                val listrec = category.listaRecomendaciones
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    items(listrec) { recomendacion ->
                        BodyRec(recomendacion, navController,screenWidth)
                    }
                }
            } else {
                navController.popBackStack()
            }
        }
    )
}

@Composable
fun BodyRec(recomend: Recomendacion, navController: NavController,screenWidth: androidx.compose.ui.unit.Dp) {
    val name = stringResource(id = recomend.nombre)
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate("${Router.TerceraVista.route}/$name") },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = recomend.imagen),
                    contentDescription = stringResource(R.string.recommendation_image),
                    modifier = Modifier.size(screenWidth * 0.15f),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(screenWidth * 0.05f))
                Text(
                    text = name,
                    fontSize = (screenWidth.value * 0.04f).sp,
                    color = Color.Black
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = stringResource(R.string.ir_a_detalle),
                tint = Color.Gray,
                modifier = Modifier
                    .size(screenWidth * 0.07f)
                    .clickable {
                        navController.navigate("${Router.TerceraVista.route}/$name")
                    }
            )
        }
    }
}