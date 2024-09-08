package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.wb.ui.ui.component.input.InputField

@Composable
internal fun AppointmentEnterName(
    name: String,
    modifier: Modifier = Modifier,
    disable: Boolean = false,
    placeholder: String = "Имя и фамилия",
    onEnterClick: () -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    InputField(
        modifier = modifier.fillMaxWidth(),
        value = name,
        disable = disable,
        placeholder = placeholder,
        onChangeValue = onChangeValue,
        onEnterClick = onEnterClick,
    )
}