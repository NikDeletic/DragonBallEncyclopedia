package rs.nikoladeletic.common.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Immutable
data class DragonBallTypography(
    val main: TextStyle,
)

internal val dragonBallTypography = DragonBallTypography(
    main = TextStyle(
        fontSize = 16.sp
    ),
)