package ru.wb.ui.ui.component.input

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import ru.wb.ui.ui.component.utils.Constants.PASS_LENGTH_IN_PASS_FIELD

@Composable
internal fun InputPassField(
    value: String,
    modifier: Modifier = Modifier,
    isInvalid: Boolean = false,
    disable: Boolean = false,
    disableEnter: Boolean = false,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    BasicTextField(
        modifier = modifier.focusRequester(focusRequester),
        value = value,
        onValueChange = { pin ->
            val input = pin
                .filter { it.isDigit() }
                .take(PASS_LENGTH_IN_PASS_FIELD)
            onChange(input)
        },
        enabled = !disable,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = { if (disableEnter) Unit else onEnterClick() }
        ),
        decorationBox = {
            DecorationBoxInputPassField(
                modifier = Modifier,
                value = value,
                isInvalid = isInvalid,
            )
        }
    )
}