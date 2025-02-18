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
            Categoria(R.string.cafeter_as,R.drawable.como_decorar_una_cafeteria_pequena_con_poco_dinero, listOf(
                Recomendacion(R.string.hardware_coffee_kitchen, R.string.cafeter_a_moderna_que_ofrece_una_variedad_de_caf_s_especiales_y_opciones_de_desayuno, R.drawable.hardwarecofe),
                Recomendacion(R.string.heavenly_desserts_liverpool, R.string.especializada_en_postres_gourmet_y_una_amplia_selecci_n_de_bebidas_calientes, R.drawable.heavenly),
                Recomendacion(R.string.bold_street_coffee, R.string.a1, R.drawable.boldstreet),
                Recomendacion(R.string.rococo_coffee_house, R.string.vsdv, R.drawable.rococo),
                Recomendacion(R.string._92_degrees_coffee, R.string.dfsdfdsfsd, R.drawable._2_degrees)
            )),
                Categoria(R.string.centros_comerciales,R.drawable.islazul_interior, listOf(
                Recomendacion(R.string.asdsa, R.string.qwewqwq, R.drawable.liverpool_one),
                Recomendacion(R.string.metquarter_liverpool, R.string.a123, R.drawable.metquarter), Recomendacion(R.string.clayton_square_shopping_centre,R.string.zxcxzcz, R.drawable.clayton_square),
                Recomendacion(R.string.st_johns_shopping_centre, R.string.mmmmmmm, R.drawable.st_johns_shopping),
                Recomendacion(R.string.cavern_walks, R.string.ppppp, R.drawable.cavern_walks)
            )),
            Categoria(R.string.restaurantes,R.drawable._7149852163198, listOf(
                Recomendacion(R.string.bundobust, R.string.ddddd, R.drawable.boundboust),
                Recomendacion(R.string.madre, R.string.cccv, R.drawable.madre),
                Recomendacion(R.string.the_art_school_restaurant, R.string.mmmm, R.drawable.the_art_school_restaurant),
                Recomendacion(R.string.mowgli_street_food, R.string.nnnn, R.drawable.mowgli_street_food),
                Recomendacion(R.string.the_london_carriage_works, R.string.kkk, R.drawable.the_london_carriage_works)
            ))
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
//            ))
        )

    fun obtenerCategorias(): List<Categoria> {
        return _categories;
    }

}