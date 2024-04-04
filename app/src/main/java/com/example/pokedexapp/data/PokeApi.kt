package com.example.pokedexapp.data

import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    @GET("/api/v2/pokemon?")
    suspend fun getPokemon(
        //@Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonDto
}
