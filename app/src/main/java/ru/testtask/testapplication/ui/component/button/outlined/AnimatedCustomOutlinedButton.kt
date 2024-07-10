package ru.testtask.testapplication.ui.component.button.outlined

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor
import ru.testtask.testapplication.ui.theme.BrandDefaultColor

@Composable
fun AnimatedCustomOutlinedButton(
    modifier: Modifier = Modifier,
    contentDefaultColor: Color = BrandDefaultColor,
    contentPrimaryColor: Color = BrandDarkModeColor,
    disableColor: Color = PurpleLightColor,
    disabled: Boolean = false,
    label: String = "",
    labelSize: TextUnit = 14.sp,
    onClick: () -> Unit = {}
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
        shape = RoundedCornerShape(30.dp),
        enabled = !disabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
            containerColor = Color.Transparent,
            disabledContentColor = disableColor,
            disabledContainerColor = Color.Transparent,
        ),
        border = BorderStroke(2.dp, color),
        interactionSource = interactionSource
    ) {
        Text(
            text = label,
            fontSize = labelSize,
            color = color
        )
    }
}