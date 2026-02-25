package rs.nikoladeletic.feature.home.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
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
import rs.nikoladeletic.feature.home.domain.repository.LocalCharactersRepository
import rs.nikoladeletic.feature.home.domain.repository.NetworkChecker

class HomeViewModel(
    private val homeRepository: HomeRepository,
    private val networkChecker: NetworkChecker,
    private val localCharactersRepository: LocalCharactersRepository
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

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val characters: Flow<PagingData<Character>> =
        searchQuery
            .debounce(100)
            .distinctUntilChanged()
            .flatMapLatest { query ->

                if (networkChecker.hasInternet()) {
                    homeRepository.getAllCharacters(
                        searchQuery = query.takeIf { it.isNotBlank() }
                    )

                } else {
                    localCharactersRepository.observeLocalCharacters()
                        .map { list ->
                            val filtered = if (query.isBlank()) {
                                list
                            } else {
                                list.filter {
                                    it.characterName.contains(query, ignoreCase = true)
                                }
                            }

                            PagingData.from(filtered)
                        }
                }
            }
            .cachedIn(viewModelScope)

    fun onAction(action: HomeScreenAction) {
        when (action) {
            is HomeScreenAction.ChangeSearchQueryText -> {
                changeSearchQueryText(action.text)
            }
        }
    }

    private fun changeSearchQueryText(text: String) {
        searchQuery.value = text
    }
}