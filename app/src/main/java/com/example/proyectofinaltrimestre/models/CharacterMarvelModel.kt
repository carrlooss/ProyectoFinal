package com.example.proyectofinaltrimestre.models

//Clase genérica para manejar la respuesta de la API de Marvel.
data class MarvelResponse<T>(
    val data: MarvelData<T>
)
//Contenedor de datos dentro de la respuesta de Marvel.
data class MarvelData<T>(
    val results: List<T>
)
//Modelo de datos para representar un personaje de Marvel.
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)
//Modelo para representar la imagen de un personaje.
data class Thumbnail(
    val path: String,
    val extension: String
)