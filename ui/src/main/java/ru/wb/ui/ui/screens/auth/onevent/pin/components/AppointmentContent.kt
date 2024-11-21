package ru.wb.ui.ui.screens.auth.onevent.pin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentEnterPin
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentTitle

@Composable
internal fun AppointmentContent(
    description: String,
    inputValue: String,
    modifier: Modifier = Modifier,
    contextString: String = "",
    title: String  = "",
    invalid: Boolean = false,
    disableEnter: Boolean = false,
    onBackClick: () -> Unit = {},
    onEnterClick: () -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        AppointmentTitle(
            description = description,
            title = title,
            modifier = Modifier,
            onCloseClick = onBackClick,
        )

        AppointmentEnterPin(
            modifier = Modifier,
            pin = inputValue,
            context = contextString,
            invalid = invalid,
            disableEnter = disableEnter,
            onChangeValue = onChangeValue,
            onEnterClick = onEnterClick,
        )
    }
}