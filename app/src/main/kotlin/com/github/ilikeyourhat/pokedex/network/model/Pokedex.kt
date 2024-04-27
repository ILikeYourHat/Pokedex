package com.github.ilikeyourhat.pokedex.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokedex(
    val name: String,
    @SerialName("pokemon_entries")
    val pokemonEntries: List<PokemonEntry>
)

@Serializable
data class PokemonEntry(
    @SerialName("entry_number")
    val entryNumber: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: PokemonSpecies
)

@Serializable
data class PokemonSpecies(
    val name: String
)