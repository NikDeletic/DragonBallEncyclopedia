package rs.nikoladeletic.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val characterName: String,
    @SerializedName("ki") val ki: String,
    @SerializedName("maxKi") val maxKi: String,
    @SerializedName("race") val race: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("description") val description: String? = null,
    @SerializedName("image") val characterImage: String? = null,
    @SerializedName("affiliation") val affiliation: String? = null,
    @SerializedName("deletedAt") val deletedAt: String? = null,
)
