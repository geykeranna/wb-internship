package ru.wb.ui.ui.screens.events.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.button.AnimatedCustomButton
import ru.wb.ui.ui.component.button.ButtonType
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN

@Composable
fun ButtonByState(
    state: String,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit,
) {
    AnimatedCustomButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN.dp),
        label = when (state) {
            ButtonState.PRESSED.id -> ButtonState.PRESSED.label
            else -> ButtonState.UNPRESSED.label
        },
        type = when (state) {
            ButtonState.PRESSED.id -> ButtonType.OUTLINED
            else -> ButtonType.DEFAULT
        },
        onClick = onClickButton
    )
}