package rs.nikoladeletic.feature.home.ui.screens.home

sealed class HomeScreenAction {
    data class ChangeSearchQueryText(val text: String) : HomeScreenAction()
}