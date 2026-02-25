package rs.nikoladeletic.feature.home.ui.screens.character

import rs.nikoladeletic.domain.model.Character

sealed class CharacterScreenAction {
    data class LoadCharacter(val characterId: Int) : CharacterScreenAction()
    data class AddCharacterToFavorites(val character: Character) : CharacterScreenAction()
    data class RemoveCharacterFromFavorites(val character: Character) : CharacterScreenAction()
    data object CloseScreen : CharacterScreenAction()
}