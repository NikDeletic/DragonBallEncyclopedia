package rs.nikoladeletic.feature.home.ui.screens.character

sealed class CharacterScreenAction {
    data class LoadCharacter(val characterId: Int) : CharacterScreenAction()
    data class AddCharacterToFavorites(val characterId: Int) : CharacterScreenAction()
    data object CloseScreen : CharacterScreenAction()
}