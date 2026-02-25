package rs.nikoladeletic.feature.home.data.remote.mapper

import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.data.remote.model.CharacterDto

fun CharacterDto.toCharacter(): Character = Character(
    characterId = characterId,
    characterName = characterName,
    ki = ki,
    maxKi = maxKi,
    race = race,
    gender = gender,
    description = description ?: "",
    characterImage = characterImage ?: "",
    affiliation = affiliation ?: "",
)