package ru.testtask.testapplication.ui.screens.events.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.button.outlined.AnimatedCustomOutlinedButton
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN

@Composable
fun ButtonByState(
    state: String,
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when(state) {
        ButtonState.PRESSED.id -> AnimatedCustomOutlinedButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN.dp),
            label = ButtonState.PRESSED.label,
            onClick = onClickButton
        )
        else -> AnimatedCustomButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN.dp),
            label = ButtonState.UNPRESSED.label,
            onClick = onClickButton
        )
    }
}