package com.example.pokedexapp.domain.model.Dto

import com.example.pokedexapp.domain.model.Stat
import com.squareup.moshi.Json

data class BaseStat(
    @field:Json(name = "base_stat")
    val baseStat: Int,
    val stat: Stat
)



