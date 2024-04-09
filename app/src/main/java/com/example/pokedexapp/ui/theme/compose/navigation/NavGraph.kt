package com.example.pokedexapp.ui.theme.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedexapp.ui.theme.PokemonViewModel
import com.example.pokedexapp.ui.theme.compose.HomeScreen
import com.example.pokedexapp.ui.theme.compose.PokemonDetailsScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: PokemonViewModel) {
    NavHost(
        navController = navController,
        startDestination = "pokemon_list")
    {
        composable("pokemon_list",) {
            HomeScreen(
                viewModel = viewModel, navController)
        }

        composable("pokemon_details/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull()
            index?.let { PokemonDetailsScreen(
                index = it,
                navigateBack = {navController.popBackStack()})}
        }
    }
}
