package com.example.proyectofinaltrimestre.providers.db

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApiClient {

    // URL base de la API de Marvel
    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

    //Crea una instancia del servicio de la API de Marvel
    fun create(publicKey: String, privateKey: String): MarvelApiService {
        // Configuración del cliente HTTP con un interceptor para autenticación
        val client = OkHttpClient.Builder()
            .addInterceptor(MarvelAuthInterceptor(publicKey, privateKey))
            .build()

        // Configuración de Retrofit para realizar las llamadas a la API
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MarvelApiService::class.java)
    }
}
