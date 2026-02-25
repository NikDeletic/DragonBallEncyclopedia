package rs.nikoladeletic.feature.home.ui

data class HomeScreenState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,

    val searchQuery: String = ""
)