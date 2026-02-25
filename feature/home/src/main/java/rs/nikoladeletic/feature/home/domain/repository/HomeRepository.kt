package rs.nikoladeletic.feature.home.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.utils.Resource

interface HomeRepository {
    fun getAllCharacters(searchQuery: String?): Flow<PagingData<Character>>
    fun loadSingleCharacter(characterId: Int) : Flow<Resource<Character>>
}