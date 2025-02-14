package com.example.a30diasejercicio

import _30DiasEjercicioTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            _30DiasEjercicioTheme(darkTheme = isDarkTheme) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppBar(
                            isDarkTheme = isDarkTheme,
                            onThemeChange = { isDarkTheme = !isDarkTheme }
                        )
                    }
                ) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(isDarkTheme: Boolean, onThemeChange: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "NBA Ranking",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        actions = {
            IconButton(onClick = onThemeChange) {
                Icon(
                    painter = painterResource(
                        id = if (isDarkTheme) R.drawable.ic_light_mode else R.drawable.ic_dark_mode
                    ),
                    contentDescription = "Toggle Theme",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AffirmationList(ListaTajetas = Listado().loadEquipos())
    }
}

@Composable
fun DiseñoTargeta(TarjetaObj: Tarjeta) {
    var isDogHobbieVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = TarjetaObj.imageResourceId),
                contentDescription = "Image Description",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        isDogHobbieVisible = !isDogHobbieVisible
                    }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(id = TarjetaObj.nombreEquipo),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = TarjetaObj.anioFormacion.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (isDogHobbieVisible) {
                Text(
                    text = "Campeonatos Ganados: " + TarjetaObj.premios.toString(),
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun AffirmationList(ListaTajetas: List<Tarjeta>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        val sortedList = ListaTajetas.sortedBy { it.premios }.reversed()
        items(sortedList) { tarjetaIndividual ->
            DiseñoTargeta(tarjetaIndividual)
        }
    }
}
