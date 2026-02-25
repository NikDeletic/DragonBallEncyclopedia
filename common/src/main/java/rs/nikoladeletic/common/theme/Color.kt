package rs.nikoladeletic.common.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val PurpleBackground = Color(0xFF1E0E2E)
val PrimaryTextColor = Color.White
val ErrorColor = Color(0xFFFF3636)

val RedButtonBgGradient = listOf(
    Color(0xFFC83142),
    Color(0xFF9B0D1C),
    Color(0xFF861018),
    Color(0xFF61060B),
    Color(0xFF3F0407)
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


@Stable
class DragonBallColors(
    primaryText: Color,
    redButtonBgGradient: List<Color>,
    orangeButtonBgGradient: List<Color>,
    greenButtonBgGradient: List<Color>,
    grayButtonBgGradient: List<Color>,
    purpleBackground: Color,
    errorColor: Color,
) {
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

    var errorColor by mutableStateOf(errorColor)
        private set

    internal fun update(other: DragonBallColors) {
        primaryText = other.primaryText
        orangeButtonBgGradient = other.orangeButtonBgGradient
        redButtonBgGradient = other.redButtonBgGradient
        greenButtonBgGradient = other.greenButtonBgGradient
        grayButtonBgGradient = other.grayButtonBgGradient
        purpleBackground = other.purpleBackground
        errorColor = other.errorColor
    }

    internal fun copy(): DragonBallColors = DragonBallColors(
        primaryText = primaryText,
        redButtonBgGradient = redButtonBgGradient,
        orangeButtonBgGradient = orangeButtonBgGradient,
        greenButtonBgGradient = greenButtonBgGradient,
        grayButtonBgGradient = grayButtonBgGradient,
        purpleBackground = purpleBackground,
        errorColor = errorColor
    )
}

internal val dragonBallColorPaletteLight = DragonBallColors(
    primaryText = PrimaryTextColor,
    redButtonBgGradient = RedButtonBgGradient,
    orangeButtonBgGradient = OrangeButtonBgGradient,
    greenButtonBgGradient = GreenButtonBgGradient,
    grayButtonBgGradient = GrayButtonBgGradient,
    purpleBackground = PurpleBackground,
    errorColor = ErrorColor,
)

internal val dragonBallColorPaletteDark = DragonBallColors(
    primaryText = PrimaryTextColor,
    orangeButtonBgGradient = OrangeButtonBgGradient,
    greenButtonBgGradient = GreenButtonBgGradient,
    grayButtonBgGradient = GrayButtonBgGradient,
    redButtonBgGradient = RedButtonBgGradient,
    purpleBackground = PurpleBackground,
    errorColor = ErrorColor,
)