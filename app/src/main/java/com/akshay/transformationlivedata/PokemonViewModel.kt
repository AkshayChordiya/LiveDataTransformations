package com.akshay.transformationlivedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class PokemonViewModel : ViewModel() {

    private var pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    private var pokemonId: MutableLiveData<Long> = MutableLiveData()

    private var pokemon: LiveData<Pokemon>

    init {
        pokemons.value = PokemonProvider.getPokemons()
        pokemon = Transformations.map(pokemonId) {
            PokemonProvider.getPokemon(it)
        }
        // Switch map example
        /*pokemon = Transformations.switchMap(pokemonId) {
            PokemonProvider.getPokemonLive(it)
        }*/
    }

    fun getPokemons() = pokemons

    fun setPokemon(id: Long) {
        pokemonId.value = id
    }

    fun getPokemon() = pokemon

}