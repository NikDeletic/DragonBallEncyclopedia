package rs.nikoladeletic.feature.home.ui

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import rs.nikoladeletic.domain.model.Character

data class HomeScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val characters: Flow<PagingData<Character>> = emptyFlow(),
    val searchQuery: String = ""
)