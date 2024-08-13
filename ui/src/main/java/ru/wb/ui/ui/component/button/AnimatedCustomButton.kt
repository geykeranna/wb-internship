package ru.wb.ui.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.BORDER_WIDTH_BUTTON
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_BUTTON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AnimatedCustomButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.DEFAULT,
    disabled: Boolean = false,
    label: String = "",
    labelStyle: TextStyle = AppTheme.typography.subheading2,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color = when {
        isPressed -> AppTheme.colors.brandColorDarkMode
        disabled -> AppTheme.colors.brandColorLight
        else -> AppTheme.colors.brandColorDefault
    }

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(CORNER_RADIUS_BUTTON.dp),
        onClick = onClick,
        enabled = !disabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = if (type == ButtonType.DEFAULT) AppTheme.colors.neutralColorSecondaryBackground else color,
            containerColor = if (type != ButtonType.DEFAULT) Color.Transparent else color,
            disabledContentColor = if (type == ButtonType.DEFAULT) AppTheme.colors.neutralColorSecondaryBackground else color,
            disabledContainerColor = if (type != ButtonType.DEFAULT) Color.Transparent else color,
        ),
        interactionSource = interactionSource,
        border = if (type == ButtonType.OUTLINED) {
            BorderStroke(BORDER_WIDTH_BUTTON.dp, color)
        } else null,
    ) {
        Text(
            text = label,
            style = labelStyle,
            color = if (type == ButtonType.DEFAULT) AppTheme.colors.neutralColorSecondaryBackground else color
        )
    }
}