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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.PokemonNameUrl

const val POKEMON_ID = 2

@Composable
fun PokemonScreen(
    pokemon: PokemonNameUrl,
    onClick: (Int) -> Unit
) {
    val splitter = pokemon.url.split("/")
    val context = LocalContext.current
    Card (
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_4))
            .clickable { onClick((splitter[splitter.size - POKEMON_ID]).toInt()) }
           ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = pokemon.name.replaceFirstChar { it.uppercase() },
                fontSize = dimensionResource(id = R.dimen.font_size_20).value.sp,
                textAlign = TextAlign.Center
            )
            val imageRequest = ImageRequest.Builder(context = context)
                .data("$POKEMON_API_IMAGE_URL${splitter[splitter.size - POKEMON_ID]}.png")
                .diskCacheKey("$POKEMON_API_IMAGE_URL${splitter[splitter.size - POKEMON_ID]}.png")
                .diskCachePolicy(CachePolicy.ENABLED)
                .build()

            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = imageRequest,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.box_height_200)),
                        contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                },
                contentDescription = null
            )
        }
    }
}
