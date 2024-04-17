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
import androidx.compose.ui.unit.dp
import com.example.pokedexapp.domain.model.Stat

@Composable
fun CustomProgressBar(progress: Float, stat: Stat) {
    LazyRow {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(ShapeDefaults.Small)
                        .height(20.dp),
                    color = stat.getStatInfo(stat.name).color,
                    trackColor = Color.LightGray
                )
                Text(text = "${(progress * 300).toInt()}/(300)",
                    color = Color.Black)
            }
        }
    }
}