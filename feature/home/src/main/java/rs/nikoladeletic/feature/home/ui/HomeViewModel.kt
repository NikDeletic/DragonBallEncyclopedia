package rs.nikoladeletic.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    val characters: Flow<PagingData<Character>> = homeRepository
        .getAllCharacters(searchQuery = null)
        .cachedIn(viewModelScope)

    fun onAction(action: HomeScreenAction) {
        when (action) {
            is HomeScreenAction.LoadCharacters -> loadCharacters()
        }
    }

    private fun loadCharacters() {
        _state.update {
            it.copy(
                characters = homeRepository.getAllCharacters(
                    searchQuery = _state.value.searchQuery.ifEmpty { null }
                ).cachedIn(viewModelScope)
            )
        }
    }

}