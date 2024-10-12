package ru.wb.ui.ui.screens.auth.onevent.name.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentEnterName
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentTitle

@Composable
internal fun AppointmentContent(
    eventLabel: String,
    value: String,
    modifier: Modifier = Modifier,
    title: String  = "",
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
            eventLabel = eventLabel,
            title = title,
            modifier = Modifier,
            onCloseClick = onBackClick,
        )

        AppointmentEnterName(
            value = value,
            disableEnter = disableEnter,
            onChangeValue = onChangeValue,
            onEnterClick = onEnterClick,
        )
    }
}