package rs.nikoladeletic.feature.home.data.local.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.utils.Resource
import rs.nikoladeletic.feature.home.data.local.dao.LocalCharactersDao
import rs.nikoladeletic.feature.home.data.local.mapper.toCharacter
import rs.nikoladeletic.feature.home.data.local.mapper.toCharacterEntity
import rs.nikoladeletic.feature.home.domain.repository.LocalCharactersRepository

class LocalCharactersRepositoryImpl(
    private val localCharactersDao: LocalCharactersDao
) : LocalCharactersRepository {

    override suspend fun observeLocalCharacters(): Flow<List<Character>> =
        localCharactersDao.observeLocalCharacters().map { characters ->
            characters.map { it.toCharacter() }
        }

    override suspend fun observeLocalCharacterById(characterId: Int): Flow<Character> =
        localCharactersDao.observeLocalCharacterById(characterId).map { it.toCharacter() }

    override suspend fun addCharacterToDatabase(character: Character): Resource<Boolean> {
        try {
            localCharactersDao.insertCharacter(character = character.toCharacterEntity())
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage ?: "")
        }
        return Resource.Success(true)
    }

    override suspend fun deleteCharacterFromDatabase(character: Character): Resource<Boolean> {
        try {
            localCharactersDao.deleteCharacter(character = character.toCharacterEntity())
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage ?: "")
        }
        return Resource.Success(true)
    }
}