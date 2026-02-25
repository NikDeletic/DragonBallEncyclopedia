package rs.nikoladeletic.feature.home.ui

sealed class HomeScreenAction {
    data class ChangeSearchQueryText(val text: String) : HomeScreenAction()
}