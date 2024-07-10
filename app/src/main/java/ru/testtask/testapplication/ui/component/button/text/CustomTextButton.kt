package ru.testtask.testapplication.ui.component.button.text

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
import ru.testtask.testapplication.ui.theme.NeutralOffWhiteColor
import ru.testtask.testapplication.ui.theme.PinkLightColor
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.PurpleLightColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    contentDefaultColor: Color = BrandDefaultColor,
    contentPrimaryColor: Color = BrandDarkModeColor,
    backgroundBorderColor: Color = NeutralOffWhiteColor,
    disableColor: Color = PurpleLightColor,
    outlineColor: Color = PinkLightColor,
    outlined: Boolean = false,
    disabled: Boolean = false,
    isPrimary: Boolean = false,
    label: String = "",
    labelSize: TextUnit = 14.sp,
    onClick: () -> Unit = {}
) {
    val mod = if (outlined) modifier
        .border(4.dp, outlineColor, RoundedCornerShape(30.dp))
        .padding(horizontal = 4.dp)
    else modifier

    Button(
        modifier = mod,
        onClick = onClick,
        shape = RoundedCornerShape(30.dp),
        enabled = !disabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = if (isPrimary) contentPrimaryColor else contentDefaultColor,
            containerColor = if(outlined) backgroundBorderColor else Color.Transparent,
            disabledContentColor = disableColor,
            disabledContainerColor = Color.Transparent,
        ),
    ) {
        Text(
            text = label,
            fontSize = labelSize,
        )
    }
}