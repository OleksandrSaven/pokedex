package com.example.pokedexapp.ui.theme.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedexapp.ui.theme.PokemonViewModel
import com.example.pokedexapp.ui.theme.compose.HomeScreen
import com.example.pokedexapp.ui.theme.compose.POKEMON_DETAILS_ROUTE
import com.example.pokedexapp.ui.theme.compose.PokemonDetailsScreen

const val POKEMON_LIST_ROUTE = "pokemon_list"
const val POKEMON_INDEX_KEY = "index"

@Composable
fun NavGraph(navController: NavHostController, viewModel: PokemonViewModel) {
    NavHost(
        navController = navController,
        startDestination = POKEMON_LIST_ROUTE)
    {
        composable(POKEMON_LIST_ROUTE) {
            HomeScreen(
                viewModel = viewModel, navController)
        }
        composable("$POKEMON_DETAILS_ROUTE/{$POKEMON_INDEX_KEY}") {
                backStackEntry ->
            val index = backStackEntry.arguments?.getString(POKEMON_INDEX_KEY)?.toIntOrNull()
            index?.let {
                PokemonDetailsScreen(
                    navigateBack = { navController.popBackStack()},
                    viewModel = viewModel,
                    index = it
                )
            }
        }
    }
}
