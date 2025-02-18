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
            )) ,Categoria(
                    R.string.lugares_emblem_ticos, R.drawable.lugares_emblematicos, listOf(
                Recomendacion(R.string.the_beatles_story, R.string.museo_dedicado_a_la_historia_de_the_beatles_una_visita_obligada_para_los_fan_ticos_de_la_música, R.drawable.the_beatles_story_entrance),
                Recomendacion(R.string.royal_albert_dock, R.string.historico_muelle_que_alberga_tiendas_restaurantes_y_museos_incluyendo_el_tate_liverpool, R.drawable.royal_albert_dock_2023),
                Recomendacion(R.string.catedral_de_liverpool, R.string.imponente_catedral_anglicana_conocida_por_su_arquitectura_y_vistas_panoramicas_de_la_ciudad, R.drawable.liverpool_anglican_cathedral_sep2012__7916053494_),
                Recomendacion(R.string.st_george_s_hall, R.string.edificio_neoclasico_que_alberga_conciertos_y_eventos_culturales_famoso_por_su_impresionante_arquitectura, R.drawable.st_george_s_hall_concert_room_liverpool_opera_lirica),
                Recomendacion(R.string.museo_de_liverpool, R.string.ofrece_exhibiciones_sobre_la_rica_historia_y_cultura_de_la_ciudad, R.drawable._310757883_dsc_7440)
            )
        ),
            Categoria(R.string.deportes,R.drawable.anfield, listOf(
                Recomendacion(R.string.anfield_stadium, R.string.anfield_description, R.drawable.panorama_of_anfield_with_new_main_stand__29676137824_),
                Recomendacion(R.string.liverpool_tennis_centre, R.string.liverpool_tennis_description, R.drawable.outdoor_courts),
                Recomendacion(R.string.royal_liverpool_golf_club, R.string.royal_liverpool_description, R.drawable.royal_liverpool_14th_0202_web_jpg_bc15edbf1f0c51714c32cc575a253f56)
            ))
        )

    fun obtenerCategorias(): List<Categoria> {
        return _categories;
    }

}