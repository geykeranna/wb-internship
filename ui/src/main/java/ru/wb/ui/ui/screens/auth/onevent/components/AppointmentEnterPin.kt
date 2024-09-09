package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.input.InputPassField
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun AppointmentEnterPin(
    pin: String,
    modifier: Modifier = Modifier,
    isInvalid: Boolean = false,
    disable: Boolean = false,
    disableEnter: Boolean = false,
    context: String = "",
    onEnterClick: () -> Unit = {},
    onChangeValue: (value: String) -> Unit = {},
) {
    val color = when {
        isInvalid -> AppTheme.colors.neutralColorInvalidText
        else -> AppTheme.colors.neutralColorSecondaryFont
    }
    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        InputPassField(
            modifier = modifier.fillMaxWidth(),
            isInvalid = isInvalid,
            value = pin,
            disable = disable,
            disableEnter = disableEnter,
            onEnterClick = onEnterClick,
            onChange = onChangeValue,
        )
        Text(
            modifier = Modifier,
            text = context,
            style = AppTheme.typography.secondary,
            color = color,
        )
    }
}