package rs.nikoladeletic.feature.home.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.data.remote.api.CharactersApi
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository

class HomeRepositoryImpl(
    private val charactersApi: CharactersApi
): HomeRepository {

    override fun getAllCharacters(searchQuery: String?): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { CharacterPagingSource(charactersApi, searchQuery) }
    ).flow

}