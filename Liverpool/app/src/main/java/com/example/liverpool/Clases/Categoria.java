package com.example.liverpool.Clases;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import java.util.List;

public class Categoria {
    @StringRes public int nombre;
    @DrawableRes public int imagen;
    public List<Recomendacion> listaRecomendaciones;

    public Categoria(int nombre, int imagen,List<Recomendacion> listaRecomendaciones) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.listaRecomendaciones = listaRecomendaciones;
    }
}

