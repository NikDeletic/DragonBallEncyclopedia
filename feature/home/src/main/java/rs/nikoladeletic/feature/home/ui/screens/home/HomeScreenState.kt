package rs.nikoladeletic.feature.home.ui.screens.home

data class HomeScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val searchQuery: String = "",
)