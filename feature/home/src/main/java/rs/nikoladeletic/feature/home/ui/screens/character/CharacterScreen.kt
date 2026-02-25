package rs.nikoladeletic.feature.home.ui.screens.character

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.common.ui.CustomButton
import rs.nikoladeletic.common.ui.CustomLoader
import rs.nikoladeletic.feature.home.ui.screens.character.components.CharacterStats
import rs.nikoladeletic.feature.home.ui.screens.home.components.SingleCharacter

@Composable
fun CharacterScreen(
    characterId: Int,
    viewModel: CharacterViewModel = koinViewModel(),
    returnToPreviousScreen: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    CharacterScreenContent(
        characterId = characterId,
        state = state,
        onAction = viewModel::onAction,
        returnToPreviousScreen = returnToPreviousScreen
    )
}

@Composable
fun CharacterScreenContent(
    characterId: Int,
    state: CharacterScreenState,
    onAction: (CharacterScreenAction) -> Unit,
    returnToPreviousScreen: () -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = characterId) {
        onAction(CharacterScreenAction.LoadCharacter(characterId))
    }

    LaunchedEffect(key1 = state.errorMessage) {
        if (state.errorMessage != null) {
            Toast.makeText(context, state.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(key1 = state.screenClosed) {
        if (state.screenClosed) {
            returnToPreviousScreen()
        }
    }

    LaunchedEffect(key1 = state.successfullyAddedToDatabase) {
        if (state.successfullyAddedToDatabase) {
            Toast.makeText(context, "Successfully added to favorites!", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(key1 = state.successfullyDeletedFromDatabase) {
        if (state.successfullyDeletedFromDatabase) {
            Toast.makeText(context, "Successfully deleted from favorites!", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                color = DragonBallTheme.colors.purpleBackground
            )
            .systemBarsPadding()
            .padding(vertical = DragonBallTheme.dimens.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleCharacter(
            character = state.loadedCharacter,
            onCharacterClick = {}
        )

        CustomButton(
            modifier = Modifier
                .padding(top = DragonBallTheme.dimens.mainPadding),
            buttonText = "Add to favorites",
            backgroundColor = Brush.verticalGradient(DragonBallTheme.colors.redButtonBgGradient),
            onClick = { onAction(CharacterScreenAction.AddCharacterToFavorites(state.loadedCharacter)) }
        )

        CustomButton(
            modifier = Modifier
                .padding(top = DragonBallTheme.dimens.mainPadding),
            buttonText = "Remove from favorites",
            backgroundColor = Brush.verticalGradient(DragonBallTheme.colors.redButtonBgGradient),
            onClick = { onAction(CharacterScreenAction.RemoveCharacterFromFavorites(state.loadedCharacter)) }
        )

        CharacterStats(
            modifier = Modifier
                .padding(top = DragonBallTheme.dimens.componentsPadding),
            character = state.loadedCharacter
        )

        CustomButton(
            modifier = Modifier
                .padding(top = DragonBallTheme.dimens.mainPadding)
                .systemBarsPadding(),
            buttonText = "Back",
            backgroundColor = Brush.verticalGradient(DragonBallTheme.colors.redButtonBgGradient),
            onClick = { onAction(CharacterScreenAction.CloseScreen) }
        )
    }

    if (state.isLoading) {
        CustomLoader()
    }
}

@Preview
@Composable
private fun Preview() {
    DragonBallTheme {
        CharacterScreenContent(
            characterId = -1,
            state = CharacterScreenState(),
            onAction = {},
            returnToPreviousScreen = {}
        )
    }
}