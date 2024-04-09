package com.example.pokedexapp.ui.theme.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.ui.theme.compose.navigation.NavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavGraph(navController = navController, viewModel = viewModel())
}