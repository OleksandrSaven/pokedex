package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonState

@Composable
fun DetailsScreen(stateInfo: PokemonState, onLoad: () -> Unit) {
    LaunchedEffect(Unit) {
        onLoad()
    }
    if (!stateInfo.loading) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonPictureScreen(state = stateInfo)

            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_2)))
            stateInfo.pokemonInfo?.types?.let { TypeScreen(it) }

            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_2)))
            WeightHeightScreen(state = stateInfo)

            Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_2)))
            stateInfo.pokemonInfo?.let { StatScreen(stat = it.baseStatus) }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.box_height_200)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
