package com.github.ilikeyourhat.pokedex.ui.pokemon.list

sealed class PokemonListScreenState {
    data object Empty: PokemonListScreenState()
    data class Content(
        val pokemons: List<String>
    ): PokemonListScreenState()
}