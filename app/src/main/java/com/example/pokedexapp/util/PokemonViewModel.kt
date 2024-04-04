package com.example.pokedexapp.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.repository.PokemonRepositoryImpl
import com.example.pokedexapp.domain.model.PokemonState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepositoryImpl
) : ViewModel() {

    var state by mutableStateOf(PokemonState())
        private set

    fun loadPokemon(limit: Int) {
        viewModelScope.launch {
            state = state.copy(
                loading = true,
                errorMessage = null
            )
            when(val result = repository.getPokemon(limit)) {
                is Resource.Success -> {
                    state = state.copy(
                        loading = false,
                        pokemon = result.data?.results
                    )
                }
                is Resource.Error -> result.message
                else -> {}
            }
        }
    }
}