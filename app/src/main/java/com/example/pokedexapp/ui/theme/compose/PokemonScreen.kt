package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.pokedexapp.data.PokemonNameUrl

@Composable
fun PokemonScreen(
    pokemon: PokemonNameUrl,
    onClick: (Int) -> Unit
) {
    val spliter = pokemon.url.split("/")
    Card (
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick((spliter[spliter.size - 2]).toInt()) }
           ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = pokemon.name.replaceFirstChar { it.uppercase() },
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${spliter[spliter.size - 2]}.png",
                loading = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                },
                contentDescription = null
            )
        }
    }
}
