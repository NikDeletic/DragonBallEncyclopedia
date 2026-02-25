package rs.nikoladeletic.feature.home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.nikoladeletic.feature.home.data.local.dao.LocalCharactersDao
import rs.nikoladeletic.feature.home.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = true
)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun charactersDao(): LocalCharactersDao
}