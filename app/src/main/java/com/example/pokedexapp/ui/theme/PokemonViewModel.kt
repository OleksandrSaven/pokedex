package com.example.pokedexapp.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.mapper.toModel
import com.example.pokedexapp.data.repository.PokemonRepositoryImpl
import com.example.pokedexapp.domain.model.PokemonState
import com.example.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepositoryImpl
) : ViewModel() {

    var state by mutableStateOf(PokemonState())
        private set

    fun loadNextPage() {
        val nextUrl = state.next
        val offset = nextUrl?.substringAfter("offset=")?.substringBefore("&")?.toIntOrNull() ?: 0
        val limit = nextUrl?.substringAfter("limit=")?.toIntOrNull() ?: 10
        loadPokemon(offset, limit)
    }

    fun loadPokemonInfo(id: Int) {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                errorMessage = null
            )
            when(val result = repository.getPokemonInfo(id)) {
                is Resource.Success -> {
                    state = state.copy(
                        loading = false,
                        errorMessage = null,
                        pokemonInfo = result.data?.toModel()
                    )
                }
                 is Resource.Error -> {
                     result.message
                 }
                else -> {}
            }
        }
    }

    fun loadPokemon(offset: Int, limit: Int) {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                errorMessage = null
            )
            when(val result = repository.getPokemon(offset, limit)) {
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
                }
                is Resource.Error -> result.message
                else -> {}
            }
        }
    }
}
