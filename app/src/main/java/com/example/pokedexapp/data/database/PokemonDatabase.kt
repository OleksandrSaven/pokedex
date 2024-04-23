package com.example.pokedexapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedexapp.data.database.dao.PokemonDao
import com.example.pokedexapp.domain.model.entity.PokemonEntity
import com.example.pokedexapp.domain.model.entity.PokemonPages

@Database(entities = [PokemonEntity::class, PokemonPages::class], version = 1, exportSchema = false)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}
