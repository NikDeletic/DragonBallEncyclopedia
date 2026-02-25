package rs.nikoladeletic.feature.home.ui.screens.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import rs.nikoladeletic.domain.utils.Resource
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository

class CharacterViewModel(
    private val charactersRepository: HomeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterScreenState())
    val state: StateFlow<CharacterScreenState> = _state.asStateFlow()

    fun onAction(action: CharacterScreenAction) {
        when (action) {
            is CharacterScreenAction.LoadCharacter -> loadCharacter(action.characterId)
            is CharacterScreenAction.AddCharacterToFavorites -> addCharacterToFavorites(action.characterId)
            is CharacterScreenAction.CloseScreen -> closeScreen()
        }
    }

    private fun loadCharacter(characterId: Int) {
        viewModelScope.launch {
            charactersRepository
                .loadSingleCharacter(characterId)
                .collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.update {
                                it.copy(
                                    isLoading = true,
                                    errorMessage = null
                                )
                            }
                        }

                        is Resource.Success -> {
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    loadedCharacter = result.data,
                                    errorMessage = null
                                )
                            }
                        }

                        is Resource.Error -> {
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    errorMessage = result.message
                                )
                            }
                        }
                    }
                }
        }
    }

    private fun closeScreen() {
        _state.update { it.copy(screenClosed = true) }
    }

    private fun addCharacterToFavorites(characterId: Int) {

    }
}