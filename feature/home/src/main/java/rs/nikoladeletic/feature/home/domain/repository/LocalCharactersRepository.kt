package rs.nikoladeletic.feature.home.domain.repository

import kotlinx.coroutines.flow.Flow
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.utils.Resource

interface LocalCharactersRepository {

    suspend fun observeLocalCharacters(): Flow<List<Character>>
    suspend fun observeLocalCharacterById(characterId: Int): Flow<Character>
    suspend fun addCharacterToDatabase(character: Character): Resource<Boolean>
    suspend fun deleteCharacterFromDatabase(character: Character): Resource<Boolean>
}