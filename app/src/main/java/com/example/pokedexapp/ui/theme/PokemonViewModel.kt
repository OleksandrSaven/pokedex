package com.example.pokedexapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.mapper.toPokemonNameUrl
import com.example.pokedexapp.data.mapper.toEntity
import com.example.pokedexapp.data.mapper.toModel
import com.example.pokedexapp.data.mapper.toPage
import com.example.pokedexapp.data.mapper.toPokemonInfo
import com.example.pokedexapp.domain.model.PokemonState
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages
import com.example.pokedexapp.domain.repository.PokemonRepository
import com.example.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val POKEMON_ON_PAGE = 10
const val OFFSET = "offset="
const val DELIMITER = "&"
const val DEFAULT_PAGE_VALUE = 0

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var state by mutableStateOf(PokemonState())
        private set

    fun loadNextPage() {
        val nextUrl = state.next
        var offset = nextUrl?.substringAfter(OFFSET)?.substringBefore(DELIMITER)?.toIntOrNull() ?: DEFAULT_PAGE_VALUE
        if (offset < state.offset) {
            offset = state.offset
        }
        val limit = POKEMON_ON_PAGE
        loadPokemon(offset, limit)
    }

    fun loadPokemonInfo(id: Int) {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                errorMessage = null
            )
            val pokemon = getPokemonFromDb(id)
            if (pokemon != null) {
                state = state.copy(
                    loading = false,
                    errorMessage = null,
                    pokemonInfo = pokemon.toPokemonInfo()
                )
            } else {
                when (val result = repository.getPokemonInfo(id)) {
                    is Resource.Success -> {
                        state = state.copy(
                            loading = false,
                            errorMessage = null,
                            pokemonInfo = result.data?.toModel()
                        )
                        result.data?.toModel()?.let {
                                savePokemon(it.toEntity())
                        }
                    }
                    is Resource.Error -> {
                        result.message
                    }
                }
            }
        }
    }

    fun loadPokemonFromDb() {
        viewModelScope.launch {
            val pokemonFromDb = getPage()
            state = state.copy(
                loading = false,
                offset = pokemonFromDb.size,
                result = pokemonFromDb.map { it.toPokemonNameUrl() }
            )
        }
    }

    private fun loadPokemon(offset: Int, limit: Int) {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                errorMessage = null
            )
            when (val result = repository.getPokemon(offset, limit)) {
                is Resource.Success -> {
                    val newData = result.data?.results ?: emptyList()
                    val existingData = state.result ?: emptyList()
                    val combinedData = existingData + newData.filter { !existingData.contains(it) }
                    state = state.copy(
                        loading = false,
                        next = result.data?.next,
                        previous = result.data?.previous,
                        result = combinedData
                    )
                    result.data?.results?.let { savePage(it.map { it.toPage() }) }
                }
                is Resource.Error -> result.message
            }
        }
    }

    private suspend fun getPokemonFromDb(index: Int): PokemonEntity {
        return repository.getPokemonFromDb(index)
    }
    private fun savePage(page: List<PokemonPages>) {
        viewModelScope.launch {
            repository.savePage(page)
        }
    }

    private suspend fun getPage(): List<PokemonPages> {
        return repository.getAllPage()
    }

    private fun savePokemon(pokemon: PokemonEntity) {
        viewModelScope.launch {
            repository.savePokemon(pokemon)
        }
    }
}
