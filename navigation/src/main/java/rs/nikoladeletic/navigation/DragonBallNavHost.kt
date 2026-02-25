package rs.nikoladeletic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import rs.nikoladeletic.feature.home.ui.screens.character.CharacterScreen
import rs.nikoladeletic.feature.home.ui.screens.home.HomeScreen

@Composable
fun DragonBallNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination
    ) {
        composable<HomeDestination> {
            HomeScreen(
                navigateToSingleCharacterScreen = { characterId ->
                    navController.navigate(CharacterDestination(characterId))
                }
            )
        }

        composable<CharacterDestination> { backStackEntry ->
            val args = backStackEntry.toRoute<CharacterDestination>()
            CharacterScreen(
                characterId = args.characterId,
                returnToPreviousScreen = { navController.navigateUp() }
            )
        }
    }
}