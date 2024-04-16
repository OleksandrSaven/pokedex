package com.example.pokedexapp.data.mapper

import com.example.pokedexapp.domain.model.Dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.PokemonInfo

fun PokemonInfoDto.toModel(): PokemonInfo {
    val id = id
    val name = name
    val height = height
    val weight = weight
    val baseExperience = baseExperience
    val type = types.map { it.type }
    val status = status
    return PokemonInfo(id, name, height, weight, baseExperience, type, status)
}



