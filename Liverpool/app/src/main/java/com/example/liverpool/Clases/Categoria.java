package com.example.liverpool.Clases;

import androidx.annotation.StringRes;

import java.util.List;

public class Categoria {
    @StringRes public int nombre;
    public List<Recomendacion> listaRecomendaciones;

    public Categoria(int nombre, List<Recomendacion> listaRecomendaciones) {
        this.nombre = nombre;
        this.listaRecomendaciones = listaRecomendaciones;
    }
}

