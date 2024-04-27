package com.github.ilikeyourhat.pokedex.domain

import com.github.ilikeyourhat.pokedex.domain.model.Pokemon
import com.github.ilikeyourhat.pokedex.network.PokemonService
import com.github.ilikeyourhat.pokedex.network.model.PokedexJson
import com.github.ilikeyourhat.pokedex.network.model.PokemonEntryJson
import com.github.ilikeyourhat.pokedex.network.model.PokemonSpeciesJson
import io.kotest.matchers.collections.shouldContainInOrder
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class PokemonListRepositoryTest {

    private val service = mockk<PokemonService>(relaxed = true)
    private val repository by lazy { PokemonListRepository(service) }

    @Test
    fun `should return pokemon list`(): Unit = runBlocking {
        coEvery { service.getPokedexData(any()) } returns pokemonData

        val pokemons = repository.getAllPokemons()

        pokemons.shouldContainInOrder(
            Pokemon(1, "Abra"),
            Pokemon(7, "Kadabra")
        )
    }

    companion object {
        val pokemonData = PokedexJson(
            name = "kanto",
            pokemonEntries = listOf(
                PokemonEntryJson(
                    entryNumber = 1,
                    pokemonSpecies = PokemonSpeciesJson(
                        name = "abra"
                    )
                ),
                PokemonEntryJson(
                    entryNumber = 7,
                    pokemonSpecies = PokemonSpeciesJson(
                        name = "kadabra"
                    )
                ),
            )
        )
    }
}