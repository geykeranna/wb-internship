package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.button.GradientButton
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentButtonsByState(
    textButtonValue: String?,
    modifier: Modifier = Modifier,
    disable: Boolean = false,
    active: Boolean = true,
    screenState: AppointmentScreenState = AppointmentScreenState.ENTER_NAME,
    onEnterClick: () -> Unit = {},
    onClick: () -> Unit = {},
) {
    val (textColor, buttonColor) = when {
        disable -> listOf(
            AppTheme.colors.neutralColorDisabledText,
            AppTheme.colors.gradient2,
        )
        else -> listOf(
            AppTheme.colors.neutralColorBackground,
            AppTheme.colors.gradient1
        )
    }
    val colorTextButton = when {
        active -> AppTheme.colors.brandColorDefault
        else -> AppTheme.colors.neutralColorSecondaryFont
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        textButtonValue?.let { text ->
            Text(
                modifier = Modifier.clickable { onClick() },
                text = text,
                style = AppTheme.typography.primary,
                color = colorTextButton,
            )
        }

        GradientButton(
            modifier = Modifier.fillMaxWidth(),
            text = screenState.textButton,
            onClick = onEnterClick,
            disabled = disable,
            textColor = textColor as Color,
            gradient = buttonColor as Brush,
        )
    }
}