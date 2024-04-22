package com.example.pokedexapp.data.constant

object PokemonStrings {
    const val HP = "hp"
    const val ATTACK = "attack"
    const val DEFENSE = "defense"
    const val SPECIAL_ATTACK = "special-attack"
    const val SPECIAL_DEFENSE = "special-defense"
    const val SPEED = "speed"
    private const val UNKNOWN = "unknown"

    fun mapToAbbreviation(name: String): String {
       return when(name) {
           HP -> "HP"
           ATTACK -> "ATK"
           DEFENSE -> "DEF"
           SPECIAL_ATTACK -> "SPA"
           SPECIAL_DEFENSE -> "SPD"
           SPEED -> "SPE"
           else -> { UNKNOWN }
       }
    }
}
