package com.example.pokedexapp.domain.model.dto

import com.example.pokedexapp.domain.model.PokemonNameUrl

data class PokemonPageDto (
    val previous: String,
    val next : String,
    val results: List<PokemonNameUrl>
)


