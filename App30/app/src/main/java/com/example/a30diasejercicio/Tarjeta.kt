package com.example.a30diasejercicio

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tarjeta(
    @StringRes val nombreEquipo: Int,
    val anioFormacion: Int,
    val premios: Int,
    @DrawableRes val imageResourceId: Int
)