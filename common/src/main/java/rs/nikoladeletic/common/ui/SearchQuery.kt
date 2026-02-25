package rs.nikoladeletic.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rs.nikoladeletic.common.R
import rs.nikoladeletic.common.theme.DragonBallTheme

@Composable
fun SearchQueryTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeholderText: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = text,
        onValueChange = { onTextChange(it) },
        placeholder = {
            Text(
                text = placeholderText,
                style = DragonBallTheme.typography.main,
                color = DragonBallTheme.colors.purpleBackground
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search, keyboardType = keyboardType),
        shape = RoundedCornerShape(80.dp),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.search_normal),
                contentDescription = "",
                tint = DragonBallTheme.colors.purpleBackground
            )
        },
        visualTransformation = visualTransformation,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = DragonBallTheme.colors.purpleBackground,
            focusedBorderColor = DragonBallTheme.colors.purpleBackground,
            errorBorderColor = DragonBallTheme.colors.errorColor,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            errorContainerColor = Color.White,
            unfocusedTextColor = DragonBallTheme.colors.purpleBackground,
            focusedTextColor = DragonBallTheme.colors.purpleBackground,
            errorTextColor = DragonBallTheme.colors.errorColor,
        )
    )
}

@Preview(apiLevel = 33)
@Composable
private fun Preview() {
    DragonBallTheme {
        SearchQueryTextField(
            text = "",
            onTextChange = {},
            placeholderText = "Search character",
            keyboardType = KeyboardType.Text,
        )
    }
}