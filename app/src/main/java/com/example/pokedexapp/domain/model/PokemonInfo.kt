package com.example.pokedexapp.domain.model

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Type>,
    val baseStatus: List<BaseStatus>
)
