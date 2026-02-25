package rs.nikoladeletic.feature.home.ui.screens.character.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.domain.model.Character

@Composable
fun CharacterStats(
    modifier: Modifier = Modifier,
    character: Character
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = DragonBallTheme.dimens.screenPadding)
            .background(
                color = Color.Black.copy(alpha = 0.3f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(all = DragonBallTheme.dimens.mainPadding),
        verticalArrangement = Arrangement.spacedBy(DragonBallTheme.dimens.componentsPadding)
    ) {
        Text(
            text = character.race + " - " + character.gender,
            style = DragonBallTheme.typography.main.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            ),
            color = DragonBallTheme.colors.primaryText
        )

        Text(
            text = "Base KI:\n ${character.ki}",
            style = DragonBallTheme.typography.main.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            ),
            color = DragonBallTheme.colors.primaryText
        )

        Text(
            text = "Total KI:\n ${character.maxKi}",
            style = DragonBallTheme.typography.main.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            ),
            color = DragonBallTheme.colors.primaryText
        )

        Text(
            text = "Affiliation:\n ${character.affiliation}",
            style = DragonBallTheme.typography.main.copy(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            ),
            color = DragonBallTheme.colors.primaryText
        )
    }
}

@Preview(apiLevel = 33)
@Composable
private fun Preview() {
    DragonBallTheme {
        CharacterStats(
            character = Character.Empty
        )
    }
}