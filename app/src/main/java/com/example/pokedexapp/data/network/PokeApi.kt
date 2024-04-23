package com.example.pokedexapp.data.network

import com.example.pokedexapp.domain.model.dto.PokemonPageDto
import com.example.pokedexapp.domain.model.dto.PokemonInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("/api/v2/pokemon?")
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonPageDto

    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonInfo(@Path("id") id: Int): PokemonInfoDto
}
