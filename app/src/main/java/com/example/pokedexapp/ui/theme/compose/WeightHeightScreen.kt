package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonInfo
import com.example.pokedexapp.domain.model.PokemonState

@Composable
fun WeightHeightScreen(state: PokemonState) {
    Row {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = String.format("%.1f kg", (state.pokemonInfo?.weight?.toFloat() ?: 1f) / 10),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                )
            Text(text = stringResource(id = R.string.weight))
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = String.format("%.1f m", (state.pokemonInfo?.height?.toFloat() ?: 1f) / 10),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(id = R.string.height))
        }
    }
}
