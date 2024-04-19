package com.example.pokedexapp.data.repository

import com.example.pokedexapp.R
import com.example.pokedexapp.data.database.dao.PokemonDao
import com.example.pokedexapp.data.network.PokeApi
import com.example.pokedexapp.domain.model.dto.PokemonDto
import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages
import com.example.pokedexapp.domain.model.entity.PokemonType
import com.example.pokedexapp.domain.repository.PokemonRepository
import com.example.pokedexapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val INTERNET_ERROR_MSG = "Cant get data from internet..."

class PokemonRepositoryImpl @Inject constructor(
    private val apiPokemon: PokeApi,
    private val pokemonDao: PokemonDao,
) : PokemonRepository {

    override suspend fun getAllPage(): List<PokemonPages> {
        return withContext(Dispatchers.IO) {
            pokemonDao.getAllPages()
        }
    }

    override suspend fun savePage(pages: List<PokemonPages>) {
        withContext(Dispatchers.IO) {
            pokemonDao.insertPage(pages)
        }
    }

    override suspend fun savePokemonType(type: PokemonType) {
        withContext(Dispatchers.IO) {
            pokemonDao.insertPokemonType(type)
        }
    }

    override suspend fun getPokemon(offset: Int, limit: Int): Resource<PokemonDto> {
        return withContext(Dispatchers.IO){
            try {
                val response = apiPokemon.getPokemon(offset, limit)
                Resource.Success(data = response)
            } catch (e: Exception) {
                Resource.Error(INTERNET_ERROR_MSG)
            }
        }
    }

    override suspend fun getPokemonInfo(id: Int): Resource<PokemonInfoDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiPokemon.getPokemonInfo(id)
                Resource.Success(data = response)
            } catch (e: Exception) {
                Resource.Error(INTERNET_ERROR_MSG)
            }
        }
    }

    override suspend fun getAllPokemon(): List<PokemonEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonFromDb(id: Int): PokemonEntity {
        return withContext(Dispatchers.IO) {
            pokemonDao.getPokemonById(id);
        }
    }

    override suspend fun savePokemon(pokemon: PokemonEntity) {
        withContext(Dispatchers.IO) {
            pokemonDao.insertPokemon(pokemon)
        }
    }
}
