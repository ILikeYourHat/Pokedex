package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ilikeyourhat.pokedex.network.PokemonService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val service: PokemonService
) : ViewModel() {

    private val _uiState = MutableLiveData<PokemonListScreenState>(PokemonListScreenState.Empty)
    val uiState: LiveData<PokemonListScreenState> = _uiState

    fun onCreate() {
        viewModelScope.launch {
            val pokemons = service.getPokedexData("kanto")
            val pokemonNames = pokemons.pokemonEntries.map { it.pokemonSpecies.name }
            _uiState.postValue(PokemonListScreenState.Content(pokemonNames))
        }
    }
}