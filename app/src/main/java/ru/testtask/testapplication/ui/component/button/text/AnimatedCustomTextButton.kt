package ru.testtask.testapplication.ui.component.button.text

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.utils.Constants.CORNER_RADIUS_BUTTON
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor
import ru.testtask.testapplication.ui.theme.subheading2

@Composable
fun AnimatedCustomTextButton(
    modifier: Modifier = Modifier,
    contentDefaultColor: Color = BrandDefaultColor,
    contentPrimaryColor: Color = BrandDarkModeColor,
    disableColor: Color = PurpleLightColor,
    disabled: Boolean = false,
    label: String = "",
    labelStyle: TextStyle = MaterialTheme.typography.subheading2,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color = when{
        isPressed -> contentPrimaryColor
        disabled -> disableColor
        else -> contentDefaultColor
    }
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(CORNER_RADIUS_BUTTON.dp),
        enabled = !disabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = if (isPressed) contentPrimaryColor else contentDefaultColor,
            containerColor = Color.Transparent,
            disabledContentColor = disableColor,
            disabledContainerColor = Color.Transparent,
        ),
        interactionSource = interactionSource
    ) {
        Text(
            text = label,
            style = labelStyle,
            color =  color
        )
    }
}