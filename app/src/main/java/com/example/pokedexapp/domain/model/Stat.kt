package com.example.pokedexapp.domain.model

import androidx.compose.ui.graphics.Color
import com.example.pokedexapp.data.constant.PokemonStrings
import com.example.pokedexapp.ui.theme.AppColors

data class Stat(
    val name: String
) {
    fun getStatInfo(name: String): StatInfo {
        return when(name){
            PokemonStrings.HP -> StatInfo(PokemonStrings.mapToAbbreviation(name) , AppColors.HP)
            PokemonStrings.ATTACK ->  StatInfo(PokemonStrings.mapToAbbreviation(name), AppColors.ATK)
            PokemonStrings.DEFENSE -> StatInfo(PokemonStrings.mapToAbbreviation(name), AppColors.DEF)
            PokemonStrings.SPECIAL_ATTACK -> StatInfo(PokemonStrings.mapToAbbreviation(name), AppColors.SPA)
            PokemonStrings.SPECIAL_DEFENSE -> StatInfo(PokemonStrings.mapToAbbreviation(name), AppColors.SPD)
            PokemonStrings.SPEED -> StatInfo(PokemonStrings.mapToAbbreviation(name), AppColors.SPE)

            else -> {StatInfo(PokemonStrings.mapToAbbreviation(name), Color.White)}
        }
    }
}
