package rs.nikoladeletic.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class DragonBallDimens(
    val screenPadding: Dp = 20.dp,
    val componentsPadding: Dp = 24.dp,
    val contentFromTopBarPadding: Dp = 40.dp,
    val textPadding: Dp = 8.dp,
    val mainPadding: Dp = 16.dp,
    val horizontalContentBlockPadding: Dp = 12.dp,
    val verticalContentBlockPadding: Dp = 16.dp
)