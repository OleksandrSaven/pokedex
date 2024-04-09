package com.example.pokedexapp.domain.model

import com.example.pokedexapp.data.PokemonNameUrl

data class PokemonState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val previous: String? = null,
    val next: String? = null,
    val result: List<PokemonNameUrl>? = emptyList()
)
