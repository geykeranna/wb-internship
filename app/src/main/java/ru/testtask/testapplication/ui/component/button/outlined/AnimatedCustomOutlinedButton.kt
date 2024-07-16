package ru.testtask.testapplication.ui.component.button.outlined

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.utils.Constants.BORDER_WIDTH_BUTTON
import ru.testtask.testapplication.ui.component.utils.Constants.CORNER_RADIUS_BUTTON
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.subheading2

@Composable
fun AnimatedCustomOutlinedButton(
    modifier: Modifier = Modifier,
    contentDefaultColor: Color = BrandDefaultColor,
    contentPrimaryColor: Color = BrandDarkModeColor,
    disableColor: Color = PurpleLightColor,
    disabled: Boolean = false,
    label: String = "",
    labelStyle: TextStyle = MaterialTheme.typography.subheading2,
    onClick: () -> Unit = {},
){
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color = when{
        isPressed -> contentPrimaryColor
        disabled -> disableColor
        else -> contentDefaultColor
    }

    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(CORNER_RADIUS_BUTTON.dp),
        enabled = !disabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent,
            disabledContentColor = disableColor,
            disabledContainerColor = Color.Transparent,
        ),
        border = BorderStroke(BORDER_WIDTH_BUTTON.dp, color),
        interactionSource = interactionSource
    ) {
        Text(
            text = label,
            color = color,
            style = labelStyle
        )
    }
}