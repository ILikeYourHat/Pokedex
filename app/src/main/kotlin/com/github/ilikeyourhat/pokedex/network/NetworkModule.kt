package com.github.ilikeyourhat.pokedex.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJson() = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofitConverterFactory(json: Json): Converter.Factory {
        return json.asConverterFactory(
            contentType = "application/json; charset=UTF8".toMediaType()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun providePokemonService(retrofit: Retrofit) = retrofit.create<PokemonService>()
}
