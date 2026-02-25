package rs.nikoladeletic.feature.home.data.remote.mapper

import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.domain.model.OriginPlanet
import rs.nikoladeletic.domain.model.Transformation
import rs.nikoladeletic.feature.home.data.remote.model.CharacterDto
import rs.nikoladeletic.feature.home.data.remote.model.OriginPlanetDto
import rs.nikoladeletic.feature.home.data.remote.model.TransformationDto

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
    transformations = transformations?.map { it.toTransformation() } ?: emptyList(),
    originPlanet = originPlanet?.toOriginPlanet() ?: OriginPlanet.Empty
)

fun TransformationDto.toTransformation(): Transformation = Transformation(
    id = id,
    name = name,
    image = image,
    ki = ki
)

fun OriginPlanetDto.toOriginPlanet(): OriginPlanet = OriginPlanet(
    id = id,
    name = name,
    isDestroyed = isDestroyed,
    image = image
)