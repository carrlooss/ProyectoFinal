package com.example.proyectofinaltrimestre.providers.db

import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

class MarvelAuthInterceptor(
    private val publicKey: String,
    private val privateKey: String
) : Interceptor {

    //Intercepta cada solicitud HTTP y agrega los parámetros de autenticación requeridos.
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url

        // Genera la marca de tiempo (ts) y el hash de autenticación
        val ts = System.currentTimeMillis().toString()
        val hash = generateMd5("$ts$privateKey$publicKey")

        // Construye la nueva URL con los parámetros de autenticación
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", publicKey)
            .addQueryParameter("hash", hash)
            .build()

        // Construye la nueva URL con los parámetros de autenticación
        val newRequest = original.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }

    //Genera un hash MD5 a partir de una cadena de entrada
    private fun generateMd5(input: String): String {
        val bytes = MessageDigest.getInstance("MD5").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
