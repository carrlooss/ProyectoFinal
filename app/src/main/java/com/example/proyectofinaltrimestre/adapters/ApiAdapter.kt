package com.example.proyectofinaltrimestre.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinaltrimestre.R
import com.example.proyectofinaltrimestre.models.Character


//Adaptador para el RecyclerView que maneja una lista de personajes de Marvel.
class ApiAdapter(
    var lista: MutableList<Character>,
    private val verImagen: (String)->Unit

    ): RecyclerView.Adapter<ApiViewHolder>() {

        //Método que se ejecuta al crear un nuevo ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.character_layout, parent, false)
        return ApiViewHolder(v)
    }

    //Devuelve la cantidad de elementos en la lista de personajes.
    override fun getItemCount()=lista.size

    //Método que asocia los datos de un personaje a un ViewHolder.
    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.render(lista[position], verImagen)
    }
}