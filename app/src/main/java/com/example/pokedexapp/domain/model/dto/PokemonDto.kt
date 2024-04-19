package com.example.pokedexapp.domain.model.dto

import com.example.pokedexapp.domain.model.PokemonNameUrl

data class PokemonDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonNameUrl>
)
