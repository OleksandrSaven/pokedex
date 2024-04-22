package com.example.pokedexapp.ui.theme.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.pokedexapp.R
import com.example.pokedexapp.domain.model.Stat

const val MAX_PROGRESS = 300
const val PROGRESS_MAX_VAL = "(300)"

@Composable
fun CustomProgressBar(progress: Float, stat: Stat) {
    LazyRow {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_8)),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(ShapeDefaults.Small)
                        .height(dimensionResource(id = R.dimen.height_20)),
                    color = stat.getStatInfo(stat.name).color,
                    trackColor = Color.LightGray
                )
                Text(text = "${(progress * MAX_PROGRESS).toInt()}$PROGRESS_MAX_VAL",
                    color = Color.Black)
            }
        }
    }
}
