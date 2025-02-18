package com.example.liverpool.Vistas

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
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
import com.example.liverpool.Clases.Recomendacion
import com.example.liverpool.Navegacion.Router
import com.example.liverpool.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaSitioEspecifico(navController: NavController, param2: String?, param3: String?) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val textSize = (screenWidth.value * 0.05f).sp
    val categories = Controlador().obtenerCategorias()
    val listaRecomendacion = categories.find { stringResource(id = it.nombre) == param2 }
    val recomendacion = listaRecomendacion?.listaRecomendaciones?.find { stringResource(id=it.nombre) == param3}
    if(recomendacion == null){throw error("No se encontró la recomendación")}
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(recomendacion.nombre), fontSize = textSize, color = Color.White)
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.volver2),
                        modifier = Modifier
                            .size(screenWidth * 0.07f)
                            .clickable { navController.popBackStack() },
                        tint = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFB71C1C))
            )
        },
        content = { paddingValues ->
            BodySitio(recomendacion, screenWidth,screenHeight, paddingValues)
        }
    )
}

@Composable
fun BodySitio(recomendacion: Recomendacion, screenWidth: androidx.compose.ui.unit.Dp,screenHeight: androidx.compose.ui.unit.Dp , paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            // Aquí comienza la tarjeta
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = recomendacion.imagen),
                        contentDescription = stringResource(R.string.imagen_del_sitio),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((screenHeight * 0.50f).coerceAtMost(400.dp))
                            .size(screenWidth * 0.50f)
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.07f))

                    // Descripción corta de la tarjeta
                    Text(
                        text = stringResource(recomendacion.descripcion),
                        fontSize = (screenWidth.value * 0.05f).sp,
                        lineHeight = (screenHeight.value * 0.05f).sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color.Black
                    )
                }
            }
        }
    }
}
