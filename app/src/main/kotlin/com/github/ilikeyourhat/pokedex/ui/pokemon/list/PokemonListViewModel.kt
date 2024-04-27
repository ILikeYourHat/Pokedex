package com.github.ilikeyourhat.pokedex.ui.pokemon.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ilikeyourhat.pokedex.domain.PokemonListRepository
import com.github.ilikeyourhat.pokedex.network.PokemonService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonListRepository
) : ViewModel() {

    private val _uiState = MutableLiveData<PokemonListScreenState>(PokemonListScreenState.Empty)
    val uiState: LiveData<PokemonListScreenState> = _uiState

    fun onCreate() {
        viewModelScope.launch {
            val pokemons = repository.getAllPokemons()
            _uiState.postValue(PokemonListScreenState.Content(pokemons))
        }
    }
}