package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.Dto.BaseStat

@Composable
fun StatScreen(stat: List<BaseStat>) {
    Text(
        text = stringResource(id = R.string.base_stats),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
    )
    LazyColumn {
        items(stat) { item ->
                Row (
                    modifier = Modifier
                        .width(300.dp)
                        .padding(2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.stat.getStatInfo(item.stat.name).name,
                        modifier = Modifier.padding(start = 1.dp))
                    CustomProgressBar(progress = item.baseStat.toFloat() / 300, item.stat)
            }
        }
    }
}
