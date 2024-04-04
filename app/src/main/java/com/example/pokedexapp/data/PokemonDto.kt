package com.example.pokedexapp.data


data class PokemonDto(

    val count: Int,

    val next: String,

    val previous: String,

    val results: List<PokemonNameUrl>
)

