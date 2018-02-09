package com.akshay.transformationlivedata

import android.arch.lifecycle.MutableLiveData

object PokemonProvider {

    private val pokemons = listOf(
            Pokemon(1, "Bulbasaur", "Grass"),
            Pokemon(2, "Squirtle", "Water"),
            Pokemon(3, "Caterpie", "Bug"),
            Pokemon(4, "Charmander", "Fire"),
            Pokemon(5, "Pidgey", "Flying")
    )

    fun getPokemons() = pokemons

    fun getPokemon(id: Long) = pokemons.first { it.id == id }

    fun getPokemonLive(id: Long) = MutableLiveData<Pokemon>().apply {
        value = pokemons.first { it.id == id }
    }
}
