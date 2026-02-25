package rs.nikoladeletic.feature.home.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import org.koin.androidx.compose.koinViewModel
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.common.ui.SearchQueryTextField
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.ui.screens.home.components.SingleCharacter

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navigateToSingleCharacterScreen: (characterId: Int) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val characters = viewModel.characters.collectAsLazyPagingItems()

    HomeScreenContent(
        state = state,
        onAction = viewModel::onAction,
        characters = characters,
        navigateToSingleCharacterScreen = navigateToSingleCharacterScreen
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    characters: LazyPagingItems<Character>,
    onAction: (HomeScreenAction) -> Unit,
    navigateToSingleCharacterScreen: (characterId: Int) -> Unit,
) {

    PullToRefreshBox(
        isRefreshing = characters.loadState.refresh is LoadState.Loading,
        onRefresh = { characters.refresh() },
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = DragonBallTheme.colors.purpleBackground
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .systemBarsPadding()
                .padding(top = DragonBallTheme.dimens.componentsPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchQueryTextField(
                modifier = Modifier
                    .padding(bottom = DragonBallTheme.dimens.componentsPadding)
                    .padding(horizontal = DragonBallTheme.dimens.screenPadding),
                text = state.searchQuery,
                onTextChange = { onAction(HomeScreenAction.ChangeSearchQueryText(it)) },
                placeholderText = "Search character",
                keyboardType = KeyboardType.Text,
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .padding(horizontal = DragonBallTheme.dimens.screenPadding),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(DragonBallTheme.dimens.textPadding),
                verticalArrangement = Arrangement.spacedBy(DragonBallTheme.dimens.horizontalContentBlockPadding)
            ) {

                items(
                    count = characters.itemCount,
                    key = characters.itemKey { it.characterId }
                ) { index ->
                    val character = characters[index]
                    if (character != null) {
                        SingleCharacter(
                            character = character,
                            onCharacterClick = { navigateToSingleCharacterScreen(character.characterId) }
                        )
                    }
                }

                if (characters.loadState.append is LoadState.Loading) {
                    item(span = { GridItemSpan(2) }) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }

    }
}

