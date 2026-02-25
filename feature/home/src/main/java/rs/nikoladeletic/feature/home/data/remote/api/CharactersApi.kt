package rs.nikoladeletic.feature.home.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rs.nikoladeletic.feature.home.data.remote.model.CharacterDto
import rs.nikoladeletic.feature.home.data.remote.model.CharactersDto

interface CharactersApi {

    @GET("characters")
    suspend fun getAllCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 10,
        @Query("name") name: String? = null
    ): CharactersDto

    @GET("characters/{id}")
    suspend fun getSingleCharacter(
        @Path("id") id: Int
    ): CharacterDto

}