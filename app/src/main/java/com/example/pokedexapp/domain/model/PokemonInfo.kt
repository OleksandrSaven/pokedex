package com.example.pokedexapp.domain.model

import com.example.pokedexapp.domain.model.dto.BaseStat

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,
    val types: List<Types>,
    val baseStatus: List<BaseStat>
)
