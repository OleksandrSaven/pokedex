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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.domain.model.Type
import com.example.pokedexapp.domain.model.Types

@Composable
fun TypeScreen(type: List<Types>) {
    LazyRow {
        items(type) { item ->
            Card (
                modifier = Modifier
                    .size(120.dp, 30.dp)
                    .padding(horizontal = 4.dp),
                colors = CardDefaults.cardColors(containerColor = item.type.getColor(item.type.name))
            ){
                Text(
                    text = item.type.name.replaceFirstChar { it.uppercase() },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(2.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}
