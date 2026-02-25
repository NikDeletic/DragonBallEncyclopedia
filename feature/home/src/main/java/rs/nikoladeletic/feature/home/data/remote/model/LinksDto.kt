package rs.nikoladeletic.feature.home.data.remote.model

import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("first") val first: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("next") val next: String,
    @SerializedName("last") val last: String,
)
