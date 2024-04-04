package com.example.pokedexapp.domain.model

import com.example.pokedexapp.data.PokemonNameUrl

data class PokemonState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val pokemon: List<PokemonNameUrl>? = null
)
