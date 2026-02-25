package rs.nikoladeletic.feature.home.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import rs.nikoladeletic.feature.home.data.local.entity.CharacterEntity

@Dao
interface LocalCharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characterEntity")
    fun observeLocalCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characterEntity WHERE id = :characterId")
    fun observeLocalCharacterById(characterId: Int): Flow<CharacterEntity>

    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)
}