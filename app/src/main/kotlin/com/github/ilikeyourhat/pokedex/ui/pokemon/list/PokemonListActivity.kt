package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.ilikeyourhat.pokedex.network.PokemonService
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create


class PokemonListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { PokemonListScreen(PokemonListScreenState.Empty) }
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }

    override fun onResume() {
        super.onResume()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(
                json.asConverterFactory(
                    "application/json; charset=UTF8".toMediaType()))
            .build()

        val service = retrofit.create<PokemonService>()

        runBlocking {
            println(service.getPokedexData("kanto"))
        }
    }
}

