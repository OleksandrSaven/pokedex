package com.example.pokedexapp.domain.model

import com.example.pokedexapp.domain.model.Dto.BaseStat

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,
    val types: List<Type>,
    val baseStatus: List<BaseStat>
)
