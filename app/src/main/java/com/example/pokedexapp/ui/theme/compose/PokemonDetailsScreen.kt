package com.example.pokedexapp.ui.theme.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedexapp.R
import com.example.pokedexapp.ui.theme.PokemonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsScreen(
    navigateBack: () -> Unit,
    viewModel: PokemonViewModel,
    index: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                title = {
                    Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = stringResource(id = R.string.pokemon_details),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = String.format("#%03d", index))
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navigateBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.back))
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            DetailsScreen(
                stateInfo = viewModel.state,
                onLoad = { viewModel.loadPokemonInfo(index) })
        }
    }
}
