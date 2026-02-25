package rs.nikoladeletic.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.nikoladeletic.common.theme.DragonBallTheme
import rs.nikoladeletic.common.utils.bounceClickable

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    backgroundColor: Brush,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .bounceClickable(
                onClick = { onClick() }
            )
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(backgroundColor, RoundedCornerShape(80.dp))
        ) {
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(
                        Brush.verticalGradient(DragonBallTheme.colors.grayButtonBgGradient),
                        RoundedCornerShape(80.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buttonText,
                    style = DragonBallTheme.typography.main.copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = DragonBallTheme.colors.primaryText
                )
            }
        }
    }

}

@Preview
@Composable
private fun Preview() {
    DragonBallTheme {
        CustomButton(
            buttonText = "Add to favorites",
            backgroundColor = Brush.verticalGradient(DragonBallTheme.colors.greenButtonBgGradient),
            onClick = {}
        )
    }
}