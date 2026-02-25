package rs.nikoladeletic.domain.model

data class Transformation(
    val id: Int,
    val name: String,
    val image: String,
    val ki: String
) {
    companion object {
        val Empty = Transformation(
            id = -1,
            name = "Test transformation name",
            image = "Test transformation image",
            ki = "Test transformation ki"
        )
    }
}
