package com.example.pokedexapp.domain.model

data class PokemonState(
    val loading: Boolean = false,
    val errorMessage: String? = null,
    val previous: String? = null,
    val next: String? = null,
    val offset: Int = 0,
    val result: List<PokemonNameUrl>? = emptyList(),
    val pokemonInfo: PokemonInfo? = null
)
