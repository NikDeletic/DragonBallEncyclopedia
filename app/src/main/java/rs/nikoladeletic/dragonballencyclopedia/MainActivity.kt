package rs.nikoladeletic.dragonballencyclopedia

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.navigation.DragonBallNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.Companion.dark(
                scrim = Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.Companion.dark(
                scrim = Color.TRANSPARENT
            )
        )
        setContent {
            DragonBallTheme {
                val navController = rememberNavController()

                DragonBallNavHost(
                    navController = navController
                )
            }
        }
    }
}
