package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.database.dao.PokemonDao
import com.example.pokedexapp.data.network.PokeApi
import com.example.pokedexapp.domain.model.dto.PokemonPageDto
import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages
import com.example.pokedexapp.domain.repository.PokemonRepository
import com.example.pokedexapp.util.IoDispatcher
import com.example.pokedexapp.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val INTERNET_ERROR_MSG = "Cant get data from internet..."

class PokemonRepositoryImpl @Inject constructor(
    private val apiPokemon: PokeApi,
    private val pokemonDao: PokemonDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PokemonRepository {

    override suspend fun getAllPage(): List<PokemonPages> {
        return withContext(ioDispatcher) {
            pokemonDao.getAllPages()
        }
    }

    override suspend fun savePage(pages: List<PokemonPages>) {
        withContext(ioDispatcher) {
            pokemonDao.insertPage(pages)
        }
    }

    override suspend fun getPokemon(offset: Int, limit: Int): Resource<PokemonPageDto> {
        return withContext(ioDispatcher){
            try {
                val response = apiPokemon.getPokemon(offset, limit)
                Resource.Success(data = response)
            } catch (e: Exception) {
                Resource.Error(INTERNET_ERROR_MSG)
            }
        }
    }

    override suspend fun getPokemonInfo(id: Int): Resource<PokemonInfoDto> {
        return withContext(ioDispatcher) {
            try {
                val response = apiPokemon.getPokemonInfo(id)
                Resource.Success(data = response)
            } catch (e: Exception) {
                Resource.Error(INTERNET_ERROR_MSG)
            }
        }
    }


    override suspend fun getPokemonFromDb(id: Int): PokemonEntity {
        return withContext(ioDispatcher) {
            pokemonDao.getPokemonById(id);
        }
    }

    override suspend fun savePokemon(pokemon: PokemonEntity) {
        withContext(ioDispatcher) {
            pokemonDao.insertPokemon(pokemon)
        }
    }
}
