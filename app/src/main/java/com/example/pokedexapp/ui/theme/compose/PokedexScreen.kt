package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedexapp.domain.model.PokemonState

@Composable
fun PokedexScreen(
    state: PokemonState,
    onLoad: () -> Unit,
    navController: NavController
) {
    val listState = rememberLazyGridState()

    LazyVerticalGrid(
        state = listState,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        content = {
            items(state.result ?: emptyList()) { pokemon ->
                PokemonScreen(pokemon = pokemon, onClick = {clickedIndex ->
                    navController.navigate("pokemon_details/$clickedIndex") {
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
        }
    )
    LaunchedEffect(listState.isScrolledToTheEnd()) {
        onLoad()
    }
}

fun LazyGridState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
