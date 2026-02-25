package rs.nikoladeletic.feature.home.data.local.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import rs.nikoladeletic.feature.home.domain.repository.NetworkChecker

class NetworkCheckerImpl(
    private val context: Context
): NetworkChecker {
    @SuppressLint("MissingPermission")
    override fun hasInternet(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}