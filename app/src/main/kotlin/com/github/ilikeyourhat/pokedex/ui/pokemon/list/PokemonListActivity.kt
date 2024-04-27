package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListActivity : ComponentActivity() {

    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState.observe(this) { state ->
            setContent { PokemonListScreen(state) }
        }
        viewModel.onCreate()
    }
}
