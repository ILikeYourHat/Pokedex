package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import com.github.ilikeyourhat.pokedex.domain.model.Pokemon

sealed class PokemonListScreenState {
    data object Empty: PokemonListScreenState()
    data class Content(
        val pokemons: List<Pokemon>
    ): PokemonListScreenState()
}