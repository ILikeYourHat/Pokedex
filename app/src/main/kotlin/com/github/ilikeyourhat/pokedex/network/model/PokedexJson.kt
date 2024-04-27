package com.github.ilikeyourhat.pokedex.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokedexJson(
    val name: String,
    @SerialName("pokemon_entries")
    val pokemonEntries: List<PokemonEntryJson>
)

@Serializable
data class PokemonEntryJson(
    @SerialName("entry_number")
    val entryNumber: Int,
    @SerialName("pokemon_species")
    val pokemonSpecies: PokemonSpeciesJson
)

@Serializable
data class PokemonSpeciesJson(
    val name: String
)