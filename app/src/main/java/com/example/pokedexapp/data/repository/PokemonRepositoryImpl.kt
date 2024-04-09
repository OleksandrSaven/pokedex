package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.PokeApi
import com.example.pokedexapp.data.PokemonDto
import com.example.pokedexapp.domain.repository.PokemonRepository
import com.example.pokedexapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val apiPokemon: PokeApi): PokemonRepository {
    override suspend fun getPokemon(offset: Int, limit: Int): Resource<PokemonDto> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiPokemon.getPokemon(offset, limit)
                Resource.Success(data = response)
            } catch (e: Exception) {
                Resource.Error("Cant get data from internet...")
            }
        }
    }

    override suspend fun getPokemonInfo(id: Int): Resource<PokemonInfoDto> {
        TODO("Not yet implemented")
    }
}