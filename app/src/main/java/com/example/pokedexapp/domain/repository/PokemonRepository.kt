package com.example.pokedexapp.domain.repository

import com.example.pokedexapp.domain.model.dto.PokemonPageDto
import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages
import com.example.pokedexapp.util.Resource

interface PokemonRepository {

    suspend fun getAllPage(): List<PokemonPages>

    suspend fun savePage(pages: List<PokemonPages>)

    suspend fun getPokemon(offset: Int, limit: Int): Resource<PokemonPageDto>

    suspend fun getPokemonInfo(id: Int): Resource<PokemonInfoDto>

    suspend fun getPokemonFromDb(id: Int): PokemonEntity

    suspend fun savePokemon(pokemon: PokemonEntity)
}
