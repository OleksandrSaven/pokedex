package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonState

const val POKEMON_API_IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

@Composable
fun PokemonPictureScreen(state: PokemonState) {
        Box(
            Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary
                )
                .height(dimensionResource(id = R.dimen.box_height_250))
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = "$POKEMON_API_IMAGE_URL${state.pokemonInfo?.id}.png",
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.box_height_200)),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                },
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_2)))
        Text(
            text = "${state.pokemonInfo?.name}".replaceFirstChar { it.uppercase() },
            fontSize = dimensionResource(id = R.dimen.font_size_25).value.sp,
            fontWeight = FontWeight.Bold,
        )
}