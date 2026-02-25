package rs.nikoladeletic.feature.home.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characterEntity")
class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val affiliation: String,
    val image: String,
    val gender: String,
    val race: String,
)