package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.Types

@Composable
fun TypeScreen(type: List<Types>) {
    LazyRow {
        items(type) { item ->
            if (item.type.name != stringResource(id = R.string.DEFAULT)) {
                Card(
                    modifier = Modifier
                        .size(
                            dimensionResource(id = R.dimen.card_type_width),
                            dimensionResource(id = R.dimen.card_type_height)
                        )
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_4)),
                    colors = CardDefaults.cardColors(containerColor = item.type.getColor(item.type.name))
                ) {
                    Text(
                        text = item.type.name.replaceFirstChar { it.uppercase() },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(dimensionResource(id = R.dimen.padding_2)),
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.font_size_20).value.sp
                    )
                }
            }
        }
    }
}
