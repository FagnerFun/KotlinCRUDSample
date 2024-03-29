package com.example.cinqsampleandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinqsampleandroid.R
import com.example.cinqsampleandroid.domain.Carro
import com.example.cinqsampleandroid.extensions.loadUrl
import kotlinx.android.synthetic.main.adapter_carro.view.*


class CarroAdapter (
    val carros: List<Carro>,
    val onClick: (Carro) -> Unit) :
    RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>() {
    // ViewHolder com as views
    class CarrosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    // Retorna a quantidade de carros na lista
    override fun getItemCount() = this.carros.size

    // Infla o layout do adapter e retorna o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrosViewHolder { // Infla a view do adapter
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.adapter_carro,
                parent, false)
        // Retorna o ViewHolder que contém todas as views
        return CarrosViewHolder(view)
    }

    // Faz o bind para atualizar o valor das views com os dados do Carro
    override fun onBindViewHolder(holder: CarrosViewHolder, position: Int) {
        val context = holder.itemView.context
        // Recupera o objeto carro
        val carro = carros[position]

        val view = holder.itemView

        with(view) {
            // Atualiza os dados do carro
            tNome.text = carro.nome

            img.loadUrl(carro.urlFoto/*, progress*/)

//            if (carro.urlFoto.trim().isEmpty()) {
//                img.setImageBitmap(null)
//            } else {
//                Picasso.get().load(carro.urlFoto).fit().into(img)
//            }

            holder.itemView.setOnClickListener { onClick(carro) }
        }
    }
}