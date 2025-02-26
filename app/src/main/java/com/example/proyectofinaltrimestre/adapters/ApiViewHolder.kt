package com.example.proyectofinaltrimestre.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinaltrimestre.databinding.CharacterLayoutBinding
import com.example.proyectofinaltrimestre.models.Character
import com.bumptech.glide.Glide
import com.example.proyectofinaltrimestre.R


//ViewHolder para representar un personaje dentro del RecyclerView.
class ApiViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val binding  = CharacterLayoutBinding.bind(v)

    //Método para asignar los datos de un personaje a los elementos de la vista.
    fun render(
        c: Character,
        verImagen: (String) -> Unit
    ){
        binding.tvName.setText (c.name)
        binding.tvDescription.setText(c.description)

        //Construcción de la URL de la imagen con protocolo seguro (https)
        val imageUrl = c.thumbnail.path.replace("http", "https") + "." + c.thumbnail.extension

        // Carga la imagen usando Glide con placeholders y manejo de errores
        Glide.with(itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.cargando)
            .error(R.drawable.errorr)
            .into(binding.ivImage)

        binding.ivImage.setOnClickListener {
            verImagen(imageUrl)
        }
    }

}
