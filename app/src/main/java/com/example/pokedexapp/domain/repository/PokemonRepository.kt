package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.data.PokemonDto
import com.example.pokedexapp.util.Resource

interface PokemonRepository {

    suspend fun getPokemon(limit: Int): Resource<PokemonDto>
}
