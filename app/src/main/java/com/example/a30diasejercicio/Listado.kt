package com.example.a30diasejercicio

class Listado {
    fun loadEquipos(): List<Tarjeta> {
        return listOf<Tarjeta>(
            Tarjeta("Paco",2024,"2 Anillos, 3 Campeonatos" , R.drawable.paco),
            Tarjeta("Luis",2024,"2 Anillos, 3 Campeonatos" , R.drawable.luis))
    }
}