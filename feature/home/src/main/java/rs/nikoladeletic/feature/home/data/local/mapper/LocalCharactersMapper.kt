package rs.nikoladeletic.feature.home.data.local.mapper

import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.model.OriginPlanet
import rs.nikoladeletic.feature.home.data.local.entity.CharacterEntity

fun Character.toCharacterEntity(): CharacterEntity = CharacterEntity(
    id = characterId,
    name = characterName,
    ki = ki,
    maxKi = maxKi,
    affiliation = affiliation,
    gender = gender,
    image = characterImage,
    race = race
)

fun CharacterEntity.toCharacter(): Character = Character(
    characterId = id,
    characterName = name,
    affiliation = affiliation,
    race = race,
    ki = ki,
    maxKi = maxKi,
    gender = gender,
    description = "",
    characterImage = image,
    originPlanet = OriginPlanet.Empty,
    transformations = emptyList(),
)