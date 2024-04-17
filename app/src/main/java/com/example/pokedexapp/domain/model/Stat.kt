package com.example.pokedexapp.domain.model

import androidx.compose.ui.graphics.Color
import com.example.pokedexapp.ui.theme.AppColors

data class Stat(
    val name: String
) {
    fun getStatInfo(name: String): StatInfo {
        return when(name){
            "hp" -> StatInfo("HP", AppColors.HP)
            "attack" ->  StatInfo("ATK", AppColors.ATK)
            "defense" -> StatInfo("DEF", AppColors.DEF)
            "special-attack" -> StatInfo("SPA", AppColors.SPA)
            "special-defense" -> StatInfo("SPD", AppColors.SPD)
            "speed" -> StatInfo("SPE", AppColors.SPE)

            else -> {StatInfo("unknown", Color.White)}
        }
    }
}
