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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.pokedexapp.domain.model.PokemonState

val POKEMON_API_IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

@Composable
fun PokemonPictureScreen(state: PokemonState) {
        Box(
            Modifier.background(
                color = MaterialTheme.colorScheme.primary
            ).height(250.dp)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = "$POKEMON_API_IMAGE_URL${state.pokemonInfo?.id}.png",
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                },
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = "${state.pokemonInfo?.name}".replaceFirstChar { it.uppercase() },
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
}