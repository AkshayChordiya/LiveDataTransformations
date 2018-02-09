package com.akshay.transformationlivedata

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_pokemon.view.*
import java.util.*

class PokemonAdapter(private val listener: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var data: List<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
                listener,
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.row_pokemon, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Pokemon>) {
        this.data = data
        notifyDataSetChanged()
    }

    class PokemonViewHolder(private val listener: (Pokemon) -> Unit,
                            itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Pokemon) = with(itemView) {
            pokemon_name.text = item.name
            setOnClickListener { listener(item) }
        }
    }
}