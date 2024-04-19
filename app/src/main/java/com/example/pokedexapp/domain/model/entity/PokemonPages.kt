package com.example.pokedexapp.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pages")
data class PokemonPages(
    @PrimaryKey
    val url: String,
    val name: String
)
