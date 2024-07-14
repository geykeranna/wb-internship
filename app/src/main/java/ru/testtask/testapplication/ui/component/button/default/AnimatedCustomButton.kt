package ru.testtask.testapplication.ui.component.button.default

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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.ui.theme.LightColor
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor

@Composable
fun AnimatedCustomButton(
    modifier: Modifier = Modifier,
    backgroundDefaultColor: Color = BrandDefaultColor,
    backgroundClickedColor: Color = BrandDarkModeColor,
    labelColor: Color = LightColor,
    disableColor: Color = PurpleLightColor,
    disabled: Boolean = false,
    label: String = "",
    labelSize: TextUnit = 14.sp,
    cornerRadius: Int = 30,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius.dp),
        onClick = onClick,
        enabled = !disabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = labelColor,
            containerColor = if (isPressed) backgroundClickedColor else backgroundDefaultColor,
            disabledContentColor = labelColor,
            disabledContainerColor = disableColor,
        ),
        interactionSource = interactionSource
    ) {
        Text(
            text = label,
            fontSize = labelSize,
        )
    }
}