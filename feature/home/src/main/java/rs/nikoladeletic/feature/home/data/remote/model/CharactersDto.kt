package rs.nikoladeletic.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("items") val characters: List<CharacterDto>,
    @SerializedName("meta") val meta: MetaDto,
    @SerializedName("links") val links: LinksDto,
)
