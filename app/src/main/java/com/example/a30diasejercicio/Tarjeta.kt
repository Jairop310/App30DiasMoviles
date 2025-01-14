package com.example.a30diasejercicio

import androidx.annotation.DrawableRes

data class Tarjeta(
    val nombreEquipo: String,
    val anioFormacion: Int,
    val premios: String,
    @DrawableRes val imageResourceId: Int
)