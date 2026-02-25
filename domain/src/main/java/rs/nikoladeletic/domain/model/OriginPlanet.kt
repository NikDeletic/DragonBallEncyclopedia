package rs.nikoladeletic.domain.model

data class OriginPlanet(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val image: String,
) {
    companion object {
        val Empty = OriginPlanet(
            id = -1,
            name = "Test origin planet name",
            isDestroyed = false,
            image = "Test origin planet image"
        )
    }
}
