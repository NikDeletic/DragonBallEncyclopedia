package rs.nikoladeletic.feature.home.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.utils.Resource
import rs.nikoladeletic.feature.home.data.remote.api.CharactersApi
import rs.nikoladeletic.feature.home.data.remote.mapper.toCharacter
import rs.nikoladeletic.feature.home.domain.repository.HomeRepository
import java.io.IOException

class HomeRepositoryImpl(
    private val charactersApi: CharactersApi
): HomeRepository {

    override fun getAllCharacters(searchQuery: String?): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { CharacterPagingSource(charactersApi, searchQuery) }
    ).flow

    override fun loadSingleCharacter(characterId: Int): Flow<Resource<Character>> = flow {
        emit(Resource.Loading)

        try {
            val response = charactersApi.getSingleCharacter(characterId)
            val character = response.toCharacter()
            emit(Resource.Success(character))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "Unexpected HTTP error",
                    code = e.code()
                )
            )
        } catch (_: IOException) {
            emit(
                Resource.Error(
                    message = "No internet connection"
                )
            )
        } catch (e: Exception) {
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "Unknown error"
                )
            )
        }
    }
}