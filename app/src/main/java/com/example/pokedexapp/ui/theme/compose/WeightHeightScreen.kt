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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonState

const val DIVIDER = 10
const val DEFAULT_FLOAT_VALUE = 1f

@Composable
fun WeightHeightScreen(state: PokemonState) {
    Row {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = String.format("%.1f kg", (state.pokemonInfo?.weight?.toFloat() ?: DEFAULT_FLOAT_VALUE) / DIVIDER),
                fontSize = dimensionResource(id = R.dimen.font_size_25).value.sp,
                fontWeight = FontWeight.Bold,
                )
            Text(text = stringResource(id = R.string.weight))
        }
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_25)))
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = String.format("%.1f m", (state.pokemonInfo?.height?.toFloat() ?: DEFAULT_FLOAT_VALUE) / DIVIDER),
                fontSize = dimensionResource(id = R.dimen.font_size_25).value.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(id = R.string.height))
        }
    }
}
