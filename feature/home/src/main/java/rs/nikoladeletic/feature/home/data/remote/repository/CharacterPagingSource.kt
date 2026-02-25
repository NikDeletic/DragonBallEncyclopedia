package rs.nikoladeletic.feature.home.data.remote.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.data.remote.api.CharactersApi
import rs.nikoladeletic.feature.home.data.remote.mapper.toCharacter

class CharacterPagingSource(
    private val charactersApi: CharactersApi,
    private val searchQuery: String? = null
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: 1
        return try {
            val response = charactersApi.getAllCharacters(page = page, limit = 10, name = searchQuery)
            LoadResult.Page(
                data = response.characters.map { it.toCharacter() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page >= response.meta.totalPages) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
    }
}