package ru.wb.ui.ui.screens.auth.onevent.components

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
import ru.wb.ui.ui.component.button.PrimaryButton
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentBottomButtons(
    modifier: Modifier = Modifier,
    disableButton: Boolean = false,
    disableTextButton: Boolean = true,
    primaryButtonText: String = "",
    secondaryButtonText: String? = null,
    onEnterClick: () -> Unit = {},
    onTextButtonClick: () -> Unit = {},
) {
    val (textColor, buttonColor) = when {
        disableButton -> listOf(
            AppTheme.colors.neutralColorDisabledText,
            AppTheme.colors.gradient2,
        )
        else -> listOf(
            AppTheme.colors.neutralColorBackground,
            AppTheme.colors.gradient1
        )
    }
    val colorTextButton = when {
        disableTextButton -> AppTheme.colors.brandColorDefault
        else -> AppTheme.colors.neutralColorSecondaryFont
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        secondaryButtonText?.let { text ->
            Text(
                modifier = Modifier.noRippleClickable { onTextButtonClick() },
                text = text,
                style = AppTheme.typography.primary,
                color = colorTextButton,
            )
        }

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = primaryButtonText,
            onClick = onEnterClick,
            disabled = disableButton,
            textColor = textColor as Color,
            gradient = buttonColor as Brush,
        )
    }
}