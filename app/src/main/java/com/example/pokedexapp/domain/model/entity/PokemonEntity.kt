package com.example.pokedexapp.domain.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,
    val hp: Int,
    val atk: Int,
    val def: Int,
    val spa: Int,
    val spd: Int,
    val speed: Int
)

@Entity(
    tableName = "pokemon_type",
    primaryKeys = ["name", "pokemonId"],
    foreignKeys = [ForeignKey(entity = PokemonEntity::class,
        parentColumns = ["id"],
        childColumns = ["pokemonId"],
        onDelete = ForeignKey.CASCADE)])
data class PokemonType(
    val name: String,
    val pokemonId: Int
)
