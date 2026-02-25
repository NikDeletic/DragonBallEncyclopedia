package rs.nikoladeletic.navigation

import kotlinx.serialization.Serializable

@Serializable
data object HomeDestination

@Serializable
data class CharacterDestination(val characterId: Int)