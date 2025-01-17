import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores personalizados
val CustomLightPrimary = Color(0xFF6200EA) // Morado
val CustomLightSecondary = Color(0xFF03DAC5) // Verde agua
val CustomLightBackground = Color(0xFFFFFFFF) // Blanco

val CustomDarkPrimary = Color(0xFFBB86FC) // Morado más claro
val CustomDarkSecondary = Color(0xFF03DAC5) // Verde agua (puedes cambiarlo)
val CustomDarkBackground = Color(0xFF121212) // Negro/gris oscuro

// Esquema de color claro
private val LightColorScheme = lightColorScheme(
    primary = CustomLightPrimary,
    secondary = CustomLightSecondary,
    background = CustomLightBackground,
    onPrimary = Color.White,
    onSecondary = Color.Black
)

// Esquema de color oscuro
private val DarkColorScheme = darkColorScheme(
    primary = CustomDarkPrimary,
    secondary = CustomDarkSecondary,
    background = CustomDarkBackground,
    onPrimary = Color.Black,
    onSecondary = Color.White
)

// Tema principal
@Composable
fun _30DiasEjercicioTheme(
    darkTheme: Boolean = false, // Cambia esto manualmente o pásalo como argumento
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
