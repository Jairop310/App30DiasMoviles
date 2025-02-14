package com.example.liverpool.Clases;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class Recomendacion {
    @StringRes
    public int nombre;
    @StringRes
    public int descripcion;
    @DrawableRes
    public int imagen;

    public Recomendacion(int nombre, int descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}
