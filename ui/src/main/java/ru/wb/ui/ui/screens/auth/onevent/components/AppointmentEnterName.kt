package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.wb.ui.ui.component.input.InputFormField

@Composable
internal fun AppointmentEnterName(
    name: String,
    modifier: Modifier = Modifier,
    disableEnter: Boolean = false,
    placeholder: String = "Имя и фамилия",
    onEnterClick: () -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    InputFormField(
        modifier = modifier.fillMaxWidth(),
        value = name,
        disableEnter = disableEnter,
        placeholder = placeholder,
        onChangeValue = onChangeValue,
        onEnterClick = onEnterClick,
    )
}