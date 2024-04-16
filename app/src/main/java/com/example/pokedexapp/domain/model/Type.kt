package com.example.pokedexapp.domain.model

import androidx.compose.ui.graphics.Color
import com.example.pokedexapp.ui.theme.AppColors

data class Type(
    val name: String
) {
    fun getColor(name: String): Color {
        return when (name) {
            "normal" -> AppColors.Normal
            "fighting" -> AppColors.Fighting
            "flying" -> AppColors.Flying
            "poison" -> AppColors.Poison
            "ground" -> AppColors.Ground
            "rock" -> AppColors.Rock
            "bug" -> AppColors.Bug
            "ghost" -> AppColors.Ghost
            "steel" -> AppColors.Steel
            "fire" -> AppColors.Fire
            "water" -> AppColors.Water
            "grass" -> AppColors.Grass
            "electric" -> AppColors.Electric
            "psychic" -> AppColors.Psychic
            "ice" -> AppColors.Ice
            "dragon" -> AppColors.Dragon
            "dark" -> AppColors.Dark
            "fairy" -> AppColors.Fairy
            else -> {
                Color.White
            }
        }
    }
}
