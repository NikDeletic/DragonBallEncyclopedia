package rs.nikoladeletic.domain.model

data class Character(
    val characterId: Int,
    val characterName: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val characterImage: String,
    val affiliation: String,
    val originPlanet: OriginPlanet,
    val transformations: List<Transformation>,
) {
    companion object {
        val Empty = Character(
            characterId = -1,
            characterName = "Test character data",
            ki = "Test character data",
            maxKi = "Test character data",
            race = "Test character data",
            gender = "Test character data",
            description = "Test character data",
            characterImage = "Test character data",
            affiliation = "Test character data",
            originPlanet = OriginPlanet.Empty,
            transformations = listOf(Transformation.Empty)
        )
    }
}
