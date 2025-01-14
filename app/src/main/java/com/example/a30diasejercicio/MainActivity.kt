package com.example.a30diasejercicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30diasejercicio.ui.theme._30DiasEjercicioTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DiasEjercicioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column {

        Cabezera()
        Spacer(modifier = Modifier.height(8.dp))
        AffirmationList(ListaTajetas = Listado().loadEquipos());

    }
}

@Composable
fun DiseñoTargeta(TarjetaObj: Tarjeta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen en la parte superior
            Image(
                painter = painterResource(id = TarjetaObj.imageResourceId),
                contentDescription = "Image Description",
                modifier = Modifier
                    .size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título de la tarjeta
            Text(
                text = stringResource(id = TarjetaObj.nombreEquipo),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = TarjetaObj.anioFormacion.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = TarjetaObj.premios.toString() + " Campeonatos",
                fontSize = 15.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun Cabezera(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono o imagen
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Reemplaza con tu ícono
            contentDescription = "Header Icon",
            modifier = Modifier
                .size(48.dp),
            tint = Color.White
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "NBA Ranking",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Ranking de los mejores equipos de la NBA",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
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

