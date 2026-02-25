package rs.nikoladeletic.feature.home.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    val state: StateFlow<HomeScreenState> =
        searchQuery
            .map { query ->
                HomeScreenState(
                    searchQuery = query
                )
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                HomeScreenState()
            )

    val characters: Flow<PagingData<Character>> =
        searchQuery
            .debounce(300)
            .distinctUntilChanged()
            .flatMapLatest { query ->
                homeRepository.getAllCharacters(
                    searchQuery = query.takeIf { it.isNotBlank() }
                )
            }

    fun onAction(action: HomeScreenAction) {
        when (action) {
            is HomeScreenAction.ChangeSearchQueryText -> changeSearchQueryText(action.text)
        }
    }

    private fun changeSearchQueryText(text: String) {
        searchQuery.value = text
    }

}