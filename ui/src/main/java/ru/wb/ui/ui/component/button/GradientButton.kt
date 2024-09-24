package ru.wb.ui.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.onClick
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    disabled: Boolean = false,
    textColor: Color = AppTheme.colors.neutralColorSecondaryBackground,
    gradient: Brush = AppTheme.colors.gradient1,
    onClick: () -> Unit = {}
) {
    val (textButtonColor, backgroundButtonColor) = when{
        disabled -> listOf(
            AppTheme.colors.neutralColorDisabledText,
            AppTheme.colors.gradient2,
        )
        else -> listOf(textColor, gradient)
    }
    Box(
        modifier = modifier
            .onClick(disabled = disabled, onClick = onClick)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundButtonColor as Brush)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = AppTheme.typography.heading3,
            color = textButtonColor as Color
        )
    }
}