package com.example.pokedexapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages
import com.example.pokedexapp.domain.model.entity.PokemonType

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pages")
    suspend fun getAllPages(): List<PokemonPages>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPage(page: List<PokemonPages>)

    @Query("SELECT * FROM pokemons WHERE  id == :id ")
    suspend fun getPokemonById(id: Int): PokemonEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonType(types: PokemonType)
}
