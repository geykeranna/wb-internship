package ru.testtask.testapplication.ui.component.button.def

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.ui.theme.LightColor
import ru.testtask.testapplication.ui.theme.PinkLightColor
import ru.testtask.testapplication.ui.theme.PurpleDefaultColor
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.PurplePrimaryColor

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    backgroundDefaultColor: Color = PurpleDefaultColor,
    backgroundPrimaryColor: Color = PurplePrimaryColor,
    labelColor: Color = LightColor,
    disableColor: Color = PurpleLightColor,
    outlineColor: Color = PinkLightColor,
    outlined: Boolean = false,
    disabled: Boolean = false,
    isPrimary: Boolean = false,
    label: String = "",
    labelSize: TextUnit = 14.sp,
    onClick: () -> Unit = {},
) {
    val mod = if (outlined) modifier
        .border(4.dp, outlineColor, RoundedCornerShape(30.dp))
        .padding(horizontal = 4.dp)
    else modifier

    Button(
        modifier = mod,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick,
        enabled = !disabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = labelColor,
            containerColor = if (isPrimary) backgroundPrimaryColor else backgroundDefaultColor,
            disabledContentColor = labelColor,
            disabledContainerColor = disableColor,
        )
    ) {
        Text(
            text = label,
            fontSize = labelSize,
        )
    }
}