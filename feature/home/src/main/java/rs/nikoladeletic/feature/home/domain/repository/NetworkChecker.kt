package rs.nikoladeletic.feature.home.domain.repository

interface NetworkChecker {
    fun hasInternet(): Boolean
}