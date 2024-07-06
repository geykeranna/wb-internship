package ru.testtask.testapplication.ui.component.button.outlined

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.ui.theme.PinkLightColor
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor
import ru.testtask.testapplication.ui.theme.BrandDefaultColor

@Composable
fun CustomOutlinedButton(
    modifier: Modifier = Modifier,
    contentDefaultColor: Color = BrandDefaultColor,
    contentPrimaryColor: Color = BrandDarkModeColor,
    disableColor: Color = PurpleLightColor,
    outlineColor: Color = PinkLightColor,
    outlined: Boolean = false,
    disabled: Boolean = false,
    isPrimary: Boolean = false,
    label: String = "",
    labelSize: TextUnit = 14.sp,
    onClick: () -> Unit = {}
){
    val mod = if (outlined) modifier
        .border(4.dp, outlineColor, RoundedCornerShape(30.dp))
        .padding(horizontal = 4.dp)
    else modifier

    val color = when{
        disabled -> disableColor
        isPrimary -> contentPrimaryColor
        else -> contentDefaultColor
    }

    OutlinedButton(
        modifier = mod,
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        enabled = !disabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = if (isPrimary) contentPrimaryColor else contentDefaultColor,
            containerColor = Color.Transparent,
            disabledContentColor = disableColor,
            disabledContainerColor = Color.Transparent,
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = SolidColor(color)
        ),
    ) {
        Text(
            modifier = Modifier,
            text = label,
            fontSize = labelSize,
        )
    }
}