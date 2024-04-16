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
import androidx.compose.ui.unit.dp
import com.example.pokedexapp.domain.model.PokemonState

@Composable
fun DetailsScreen(stateInfo: PokemonState, onLoad: () -> Unit) {
    LaunchedEffect(Unit) {
        onLoad()
    }
    if (!stateInfo.loading) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonPictureScreen(state = stateInfo)

            Spacer(modifier = Modifier.padding(2.dp))
            stateInfo.pokemonInfo?.types?.let { TypeScreen(it) }

            Spacer(modifier = Modifier.padding(2.dp))
            WeightHeightScreen(state = stateInfo)

            Spacer(modifier = Modifier.padding(2.dp))
            stateInfo.pokemonInfo?.let { StatScreen(stat = it.baseStatus) }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
