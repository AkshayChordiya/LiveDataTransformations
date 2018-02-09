package com.akshay.transformationlivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting the list
        val pokemonAdapter = PokemonAdapter { pokemon ->
            // Item click listener
            val intent = Intent(this, PokemonDetailActivity::class.java).apply {
                putExtra("id", pokemon.id)
            }
            startActivity(intent)
        }
        pokemon_list.layoutManager = LinearLayoutManager(this)
        pokemon_list.adapter = pokemonAdapter

        // Getting data from ViewModel
        val pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        pokemonViewModel.getPokemons().observe(this, Observer {
            pokemonAdapter.swapData(it!!)
        })
    }
}
