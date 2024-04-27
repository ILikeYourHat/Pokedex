package com.github.ilikeyourhat.pokedex.network

import com.github.ilikeyourhat.pokedex.network.model.PokedexJson
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokedex/{name}/")
    suspend fun getPokedexData(@Path("name") name: String): PokedexJson
}