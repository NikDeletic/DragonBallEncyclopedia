package rs.nikoladeletic.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val BurgundyBackground = Color(0xFF62272D)
val LightBurgundyBackground = Color(0xFF620E17)
val PurpleBackground = Color(0xFF1E0E2E)
val PrimaryTextColor = Color.White
val ErrorColor = Color(0xFFFF3636)

val RedButtonBgGradient = listOf(
    Color(0xFFC83142),
    Color(0xFF9B0D1C),
    Color(0xFF861018),
    Color(0xFF61060B)
)

val OrangeButtonBgGradient = listOf(
    Color(0xFFFFFFFF),
    Color(0xFFFFBE00),
    Color(0xFFFFBE00),
    Color(0xFFFFBE00),
    Color(0xFFFF7800),
    Color(0xFFCE2E00),
)

val GreenButtonBgGradient = listOf(
    Color(0xFF4DA551),
    Color(0xFF52A55A),
    Color(0xFF67BE58),
    Color(0xFF7CEE72)
)

val GrayButtonBgGradient = listOf(
    Color(0xFF7C7A7A),
    Color(0xFF929292),
    Color(0xFFBFBFBF),
    Color(0xFFE8E8E8)
)

val BottomNavigationMenuColor = Color(0xFF320106)
val BottomNavigationMenuIconsColor = Color(0xFFFFFFFF)


@Stable
class DragonBallColors(
    burgundyBackground: Color,
    lightBurgundyBackground: Color,
    primaryText: Color,
    redButtonBgGradient: List<Color>,
    orangeButtonBgGradient: List<Color>,
    greenButtonBgGradient: List<Color>,
    grayButtonBgGradient: List<Color>,
    purpleBackground: Color,
    bottomNavigationColor: Color,
    bottomNavigationIconsColor: Color,
    errorColor: Color,
) {
    var burgundyBackground by mutableStateOf(burgundyBackground)
        private set

    var lightBurgundyBackground by mutableStateOf(lightBurgundyBackground)
        private set

    var primaryText by mutableStateOf(primaryText)
        private set

    var orangeButtonBgGradient by mutableStateOf(orangeButtonBgGradient)
        private set

    var redButtonBgGradient by mutableStateOf(redButtonBgGradient)
        private set

    var greenButtonBgGradient by mutableStateOf(greenButtonBgGradient)
        private set

    var grayButtonBgGradient by mutableStateOf(grayButtonBgGradient)
        private set

    var purpleBackground by mutableStateOf(purpleBackground)
        private set

    var bottomNavigationColor by mutableStateOf(bottomNavigationColor)
        private set

    var bottomNavigationIconsColor by mutableStateOf(bottomNavigationIconsColor)
        private set

    var errorColor by mutableStateOf(errorColor)
        private set

    internal fun update(other: DragonBallColors) {
        burgundyBackground = other.burgundyBackground
        lightBurgundyBackground = other.lightBurgundyBackground
        primaryText = other.primaryText
        orangeButtonBgGradient = other.orangeButtonBgGradient
        redButtonBgGradient = other.redButtonBgGradient
        greenButtonBgGradient = other.greenButtonBgGradient
        grayButtonBgGradient = other.grayButtonBgGradient
        purpleBackground = other.purpleBackground
        bottomNavigationColor = other.bottomNavigationColor
        bottomNavigationIconsColor = other.bottomNavigationIconsColor
        errorColor = other.errorColor
    }

    internal fun copy(): DragonBallColors = DragonBallColors(
        burgundyBackground = burgundyBackground,
        lightBurgundyBackground = lightBurgundyBackground,
        primaryText = primaryText,
        redButtonBgGradient = redButtonBgGradient,
        orangeButtonBgGradient = orangeButtonBgGradient,
        greenButtonBgGradient = greenButtonBgGradient,
        grayButtonBgGradient = grayButtonBgGradient,
        purpleBackground = purpleBackground,
        bottomNavigationColor = bottomNavigationColor,
        bottomNavigationIconsColor = bottomNavigationIconsColor,
        errorColor = errorColor
    )
}

internal val dragonBallColorPaletteLight = DragonBallColors(
    burgundyBackground = BurgundyBackground,
    lightBurgundyBackground = LightBurgundyBackground,
    primaryText = PrimaryTextColor,
    redButtonBgGradient = RedButtonBgGradient,
    orangeButtonBgGradient = OrangeButtonBgGradient,
    greenButtonBgGradient = GreenButtonBgGradient,
    grayButtonBgGradient = GrayButtonBgGradient,
    purpleBackground = PurpleBackground,
    bottomNavigationColor = BottomNavigationMenuColor,
    bottomNavigationIconsColor = BottomNavigationMenuIconsColor,
    errorColor = ErrorColor,
)

internal val dragonBallColorPaletteDark = DragonBallColors(
    burgundyBackground = BurgundyBackground,
    lightBurgundyBackground = LightBurgundyBackground,
    primaryText = PrimaryTextColor,
    orangeButtonBgGradient = OrangeButtonBgGradient,
    greenButtonBgGradient = GreenButtonBgGradient,
    grayButtonBgGradient = GrayButtonBgGradient,
    redButtonBgGradient = RedButtonBgGradient,
    purpleBackground = PurpleBackground,
    bottomNavigationColor = BottomNavigationMenuColor,
    bottomNavigationIconsColor = BottomNavigationMenuIconsColor,
    errorColor = ErrorColor,
)