package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.PokemonDto
import com.example.pokedexapp.data.repository.PokemonInfoDto
import com.example.pokedexapp.util.Resource

interface PokemonRepository {

    suspend fun getPokemon(offset: Int, limit: Int): Resource<PokemonDto>

    suspend fun getPokemonInfo(id: Int): Resource<PokemonInfoDto>
}
