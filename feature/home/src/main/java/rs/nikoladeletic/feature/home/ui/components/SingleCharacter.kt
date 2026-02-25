package rs.nikoladeletic.feature.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.common.utils.bounceClickable
import rs.nikoladeletic.domain.model.Character
import rs.nikoladeletic.feature.home.R

@Composable
fun SingleCharacter(
    modifier: Modifier = Modifier,
    character: Character,
    onCharacterClick: (Character) -> Unit,
) {
    Box(
        modifier = modifier
            .size(250.dp)
            .bounceClickable(onClick = { onCharacterClick(character) })
            .background(
                brush = Brush.verticalGradient(DragonBallTheme.colors.redButtonBgGradient),
                shape = RoundedCornerShape(24.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(character.characterImage)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.character_image),
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                    color = DragonBallTheme.colors.purpleBackground
                )
            },
            error = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.error_icon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            }
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = DragonBallTheme.dimens.mainPadding),
            text = character.characterName,
            style = DragonBallTheme.typography.main,
            color = DragonBallTheme.colors.primaryText,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun Preview() {
    DragonBallTheme {
        SingleCharacter(
            character = Character.Empty,
            onCharacterClick = {}
        )
    }
}