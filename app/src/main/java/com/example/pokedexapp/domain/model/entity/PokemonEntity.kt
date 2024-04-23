package com.example.pokedexapp.domain.model.entity

import androidx.room.Entity
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
    val speed: Int,
    val slot1: String,
    val slot2: String
)
