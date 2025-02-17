package com.example.liverpool.Vistas

import androidx.lifecycle.ViewModel
import com.example.liverpool.Clases.Categoria
import com.example.liverpool.Clases.Recomendacion
import com.example.liverpool.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Controlador : ViewModel()
{
    public val _categories =
        listOf(
            Categoria(R.string.cafeter_as, listOf(
                Recomendacion(R.string.hardware_coffee_kitchen, R.string.cafeter_a_moderna_que_ofrece_una_variedad_de_caf_s_especiales_y_opciones_de_desayuno, R.drawable.hardwarecofe),
                Recomendacion(R.string.heavenly_desserts_liverpool, R.string.especializada_en_postres_gourmet_y_una_amplia_selecci_n_de_bebidas_calientes, R.drawable.heavenly),
                Recomendacion(R.string.bold_street_coffee, R.string.a1, R.drawable.boldstreet),
                Recomendacion(R.string.rococo_coffee_house, R.string.vsdv, R.drawable.rococo),
                Recomendacion(R.string._92_degrees_coffee, R.string.dfsdfdsfsd, R.drawable._2_degrees)
            ))
//            Categoria("Centros Comerciales", listOf(
//                Recomendacion("Liverpool ONE", "Extenso complejo comercial con más de 170 tiendas, restaurantes y opciones de entretenimiento.", "https://www.liverpool-one.com/"),
//                Recomendacion("Metquarter Liverpool", "Centro comercial elegante que alberga boutiques de lujo y opciones gastronómicas.", "https://metquarter.com/"),
//                Recomendacion("Clayton Square Shopping Centre", "Centro comercial céntrico con una variedad de tiendas minoristas y servicios.", "https://claytonsquare.co.uk/"),
//                Recomendacion("St Johns Shopping Centre", "Ofrece una amplia gama de tiendas y es conocido por su mercado interior.", "https://stjohns-shopping.co.uk/"),
//                Recomendacion("Cavern Walks", "Centro comercial boutique que cuenta con tiendas de diseñadores locales y nacionales.", "https://www.cavernwalks.co.uk/")
//            )),
//            Categoria("Restaurantes", listOf(
//                Recomendacion("Bundobust", "Restaurante que fusiona la comida callejera india con una excelente selección de cervezas artesanales.", "https://bundobust.com/liverpool"),
//                Recomendacion("Madre", "Ofrece auténtica cocina mexicana en un ambiente vibrante en el Albert Dock.", "https://thisismadre.co.uk/"),
//                Recomendacion("The Art School Restaurant", "Restaurante de alta cocina que destaca por su menú innovador y elegante ambiente.", "https://theartschoolrestaurant.co.uk/"),
//                Recomendacion("Mowgli Street Food", "Conocido por su auténtica comida callejera india y ambiente acogedor.", "https://www.mowglistreetfood.com/"),
//                Recomendacion("The London Carriage Works", "Restaurante galardonado que ofrece cocina británica moderna con ingredientes locales.", "https://www.thelondoncarriageworks.co.uk/")
//            )),
//            Categoria("Lugares Emblemáticos", listOf(
//                Recomendacion("The Beatles Story", "Museo dedicado a la historia de The Beatles, una visita obligada para los fanáticos de la música.", "https://www.beatlesstory.com/"),
//                Recomendacion("Royal Albert Dock", "Histórico muelle que alberga tiendas, restaurantes y museos, incluyendo el Tate Liverpool.", "https://www.albertdock.com/"),
//                Recomendacion("Catedral de Liverpool", "Imponente catedral anglicana conocida por su arquitectura y vistas panorámicas de la ciudad.", "https://www.liverpoolcathedral.org.uk/"),
//                Recomendacion("St. George's Hall", "Edificio neoclásico que alberga conciertos y eventos culturales, famoso por su impresionante arquitectura.", "https://www.stgeorgeshallliverpool.co.uk/"),
//                Recomendacion("Museo de Liverpool", "Ofrece exhibiciones sobre la rica historia y cultura de la ciudad.", "a")
//            )),
//            Categoria("Deportes", listOf(
//                Recomendacion("Anfield Stadium", "Estadio icónico y hogar del Liverpool FC, conocido por su apasionada afición y rica historia en el fútbol.", "a"),
//                Recomendacion("Liverpool Tennis Centre", "Parte del Wavertree Sports Park, cuenta con seis pistas de tenis cubiertas y seis al aire libre, y ha sido sede de importantes torneos.", "a"),
//                Recomendacion("Royal Liverpool Golf Club", "Uno de los clubes de golf más antiguos de Inglaterra, ha sido sede del Open Championship en numerosas ocasiones.", "a")
//            )),
//            Categoria("Playas", listOf(
//                Recomendacion("Formby Beach", "Playa de arena dorada rodeada de dunas y bosques de pinos, ideal para caminatas y avistamiento de vida silvestre.", "a"),
//                Recomendacion("Crosby Beach", "Famosa por la instalación artística 'Another Place' de Antony Gormley, que presenta 100 figuras de hierro a lo largo de la costa.", "a"),
//                Recomendacion("West Kirby Beach", "Playa popular para deportes acuáticos como el windsurf y ofrece vistas panorámicas del estuario de Dee.", "a"),
//                Recomendacion("New Brighton Beach", "Playa familiar con un paseo marítimo vibrante, atracciones y vistas al estuario del Mersey.", "a")
//            )),
        )

    fun obtenerCategorias(): List<Categoria> {
        return _categories;
    }

}