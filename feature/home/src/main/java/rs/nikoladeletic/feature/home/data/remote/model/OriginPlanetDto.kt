package rs.nikoladeletic.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class OriginPlanetDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("isDestroyed") val isDestroyed: Boolean,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("deletedAt") val deletedAt: String? = null,
)
