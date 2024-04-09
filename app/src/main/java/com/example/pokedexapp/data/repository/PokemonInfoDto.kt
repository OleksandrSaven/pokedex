package com.example.pokedexapp.data.repository

import com.example.pokedexapp.domain.model.Type

data class PokemonInfoDto(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,
    val type: List<Type>
)
