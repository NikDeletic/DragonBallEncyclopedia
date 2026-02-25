package rs.nikoladeletic.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun DragonBallTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        dragonBallColorPaletteDark
    } else {
        dragonBallColorPaletteLight
    }

    val typography = dragonBallTypography
    val dimens = DragonBallDimens()

    ProvideDragonBallThemeValues(
        colors = colors,
        typography = typography,
        dimens = dimens,
        content = content
    )
}

object DragonBallTheme {
    val colors: DragonBallColors
        @Composable
        get() = LocalDragonBallColors.current

    val typography: DragonBallTypography
        @Composable
        get() = LocalDragonBallTypography.current

    val dimens: DragonBallDimens
        @Composable
        get() = LocalDragonBallDimens.current
}

private val LocalDragonBallColors = staticCompositionLocalOf<DragonBallColors> {
    error("No DragonBallColors provided")
}

private val LocalDragonBallTypography = staticCompositionLocalOf<DragonBallTypography> {
    error("No DragonBallTypography provided")
}

private val LocalDragonBallDimens = staticCompositionLocalOf<DragonBallDimens> {
    error("No DragonBallDimens provided")
}

@Composable
fun ProvideDragonBallThemeValues(
    colors: DragonBallColors,
    typography: DragonBallTypography,
    dimens: DragonBallDimens,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }
    colorPalette.update(colors)

    CompositionLocalProvider(
        LocalDragonBallColors provides colorPalette,
        LocalDragonBallDimens provides dimens,
        LocalDragonBallTypography provides typography,
        content = content
    )

}