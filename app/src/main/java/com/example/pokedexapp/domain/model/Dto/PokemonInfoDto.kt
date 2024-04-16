package com.example.pokedexapp.domain.model.Dto

import com.example.pokedexapp.domain.model.Types
import com.squareup.moshi.Json

data class PokemonInfoDto(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @field:Json(name="base_experience")
    val baseExperience: Int,
    @field:Json(name="types")
    val types: List<Types>,
    @field:Json(name = "stats")
    val status: List<BaseStat>
)
