package rs.nikoladeletic.feature.home.ui.screens.character

import rs.nikoladeletic.domain.model.Character

data class CharacterScreenState(
    val isLoading: Boolean = false,
    val screenClosed: Boolean = false,
    val errorMessage: String? = null,

    val loadedCharacter: Character = Character.Empty
)
