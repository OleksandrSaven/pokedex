package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonState

const val LAST_ELEMENT = 1
const val COUNT_COLUMN = 2
const val POKEMON_DETAILS_ROUTE = "pokemon_details"

@Composable
fun PokedexScreen(
    state: PokemonState,
    onLoad: () -> Unit,
    navController: NavController
) {
    val listState = rememberLazyGridState()

    LazyVerticalGrid(
        state = listState,
        columns = GridCells.Fixed(COUNT_COLUMN),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_4)),
        content = {
            items(state.result ?: emptyList()) { pokemon ->
                PokemonScreen(pokemon = pokemon, onClick = {clickedIndex ->
                    navController.navigate(
                        "$POKEMON_DETAILS_ROUTE/$clickedIndex") {
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
        }
    )
    LaunchedEffect(listState.isScrolledToTheEnd()) {
       if (listState.isScrolledToTheEnd()){
           onLoad() }
    }
}

fun LazyGridState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - LAST_ELEMENT
