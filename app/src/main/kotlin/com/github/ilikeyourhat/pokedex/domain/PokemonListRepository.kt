package com.github.ilikeyourhat.pokedex.domain

import com.github.ilikeyourhat.pokedex.domain.model.Pokemon
import com.github.ilikeyourhat.pokedex.network.PokemonService
import com.github.ilikeyourhat.pokedex.utils.capitalized
import javax.inject.Inject

class PokemonListRepository @Inject constructor(
    private val service: PokemonService
) {

    suspend fun getAllPokemons(): List<Pokemon> {
        val entries = service.getPokedexData("kanto")
        return entries.pokemonEntries
            .map { pokemonEntryJson ->
                Pokemon(
                    id = pokemonEntryJson.entryNumber.toLong(),
                    name = pokemonEntryJson.pokemonSpecies.name.capitalized()
                )
            }
    }
}