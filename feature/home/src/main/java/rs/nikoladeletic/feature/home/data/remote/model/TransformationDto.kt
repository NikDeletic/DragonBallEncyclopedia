package rs.nikoladeletic.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class TransformationDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ki") val ki: String,
    @SerializedName("image") val image: String,
    @SerializedName("deletedAt") val deletedAt: String? = null,
)
