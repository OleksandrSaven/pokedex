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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.dto.BaseStat

const val MAX_VALUE = 300

@Composable
fun StatScreen(stat: List<BaseStat>) {
    Text(
        text = stringResource(id = R.string.base_stats),
        fontSize = dimensionResource(id = R.dimen.font_size_25).value.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_16),
            top = dimensionResource(id = R.dimen.padding_8),
            bottom = dimensionResource(id = R.dimen.padding_8))
    )
    LazyColumn {
        items(stat) { item ->
                Row (
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.stat_screen_width))
                        .padding(dimensionResource(id = R.dimen.padding_2)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.stat.getStatInfo(item.stat.name).name,
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_1)))
                    CustomProgressBar(progress = item.baseStat.toFloat() / MAX_VALUE, item.stat)
            }
        }
    }
}
