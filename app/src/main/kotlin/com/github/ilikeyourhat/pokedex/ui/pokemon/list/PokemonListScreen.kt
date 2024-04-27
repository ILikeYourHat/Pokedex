package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ilikeyourhat.pokedex.domain.model.Pokemon
import com.github.ilikeyourhat.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(state: PokemonListScreenState) {
    PokedexTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("test") }
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    when (state) {
                        is PokemonListScreenState.Content -> PokemonList(state)
                        PokemonListScreenState.Empty -> EmptyPokemonList()
                    }
                }
            }
        )
    }
}

@Composable
fun EmptyPokemonList() {
    Text(
        text = "Hello world!"
    )
}

@Composable
fun PokemonList(content: PokemonListScreenState.Content) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(content.pokemons) { pokemon ->
            Text(text = pokemon.name, modifier = Modifier.fillParentMaxWidth())
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_5",
)
fun PokemonListScreenPreview_full() {
    PokemonListScreen(
        PokemonListScreenState.Content(
            pokemons = listOf(
                Pokemon(1, "Bulbasaur"),
                Pokemon(7, "Pikachu")
            )
        )
    )
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_5",
)
fun PokemonListScreenPreview_empty() {
    PokemonListScreen(
        PokemonListScreenState.Empty
    )
}
