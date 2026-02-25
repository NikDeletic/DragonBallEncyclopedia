package rs.nikoladeletic.feature.home.ui.screens.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.utils.Resource
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository
import rs.nikoladeletic.feature.home.domain.repository.LocalCharactersRepository
import rs.nikoladeletic.feature.home.domain.repository.NetworkChecker

class CharacterViewModel(
    private val charactersRepository: HomeRepository,
    private val localCharactersRepository: LocalCharactersRepository,
    private val networkChecker: NetworkChecker,
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterScreenState())
    val state: StateFlow<CharacterScreenState> = _state.asStateFlow()

    fun onAction(action: CharacterScreenAction) {
        when (action) {
            is CharacterScreenAction.LoadCharacter -> loadCharacter(action.characterId)
            is CharacterScreenAction.AddCharacterToFavorites -> addCharacterToFavorites(action.character)
            is CharacterScreenAction.RemoveCharacterFromFavorites -> removeCharacterFromFavorites(action.character)
            is CharacterScreenAction.CloseScreen -> closeScreen()
        }
    }

    private fun loadCharacter(characterId: Int) {
        viewModelScope.launch {
            if (networkChecker.hasInternet()) {
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
            } else {
                localCharactersRepository.observeLocalCharacterById(characterId)
                    .catch { errorMessage ->
                        _state.update { it.copy(
                            errorMessage = errorMessage.message
                        ) }
                    }
                    .collect { result ->
                        _state.update { it.copy(
                            loadedCharacter = result
                        ) }
                    }
            }
        }
    }

    private fun closeScreen() {
        _state.update { it.copy(screenClosed = true) }
    }

    private fun addCharacterToFavorites(character: Character) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            val response = localCharactersRepository.addCharacterToDatabase(character = character)
            when (response) {
                is Resource.Success -> {
                    response.data.let {
                        _state.update { it.copy(
                            isLoading = false,
                            successfullyAddedToDatabase = true
                        ) }
                    }
                }

                is Resource.Error -> {
                    response.message.let { message ->
                        _state.update { it.copy(
                            isLoading = false,
                            errorMessage = message
                        ) }
                    }
                }
                is Resource.Loading -> { /* Do nothing */ }
            }
        }
    }

    private fun removeCharacterFromFavorites(character: Character) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            val response = localCharactersRepository.deleteCharacterFromDatabase(character = character)
            when (response) {
                is Resource.Success -> {
                    response.data.let {
                        _state.update { it.copy(
                            isLoading = false,
                            successfullyDeletedFromDatabase = true
                        ) }
                    }
                }

                is Resource.Error -> {
                    response.message.let { message ->
                        _state.update { it.copy(
                            isLoading = false,
                            errorMessage = message
                        ) }
                    }
                }
                is Resource.Loading -> { /* Do nothing */ }
            }
        }
    }
}