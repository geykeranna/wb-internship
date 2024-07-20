package ru.testtask.testapplication.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.utils.Constants.PASS_LENGTH_IN_PASS_FIELD
import ru.testtask.testapplication.ui.component.utils.Constants.SIZE_OF_PASS_ITEMS
import ru.testtask.testapplication.ui.theme.NeutralActiveColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.heading1

@Composable
fun InputPassField(
    value: String,
    modifier: Modifier = Modifier,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester),
        value = value,
        onValueChange = {pin ->
            onChange(pin.take(PASS_LENGTH_IN_PASS_FIELD))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = { onEnterClick() }
        ),
        decorationBox = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(PASS_LENGTH_IN_PASS_FIELD){
                    PinCodeDot(value = value, index = it)
                }
            }
        }
    )
}

@Composable
fun PinCodeDot(value: String, index: Int) {
    Box(
        modifier = Modifier
            .size(SIZE_OF_PASS_ITEMS.dp),
        contentAlignment = Alignment.Center
    ){
        if (value.getOrNull(index) != null){
            Text(
                text = value.getOrNull(index).toString(),
                style = MaterialTheme.typography.heading1,
                color = NeutralActiveColor
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(NeutralLineColor)
            )
        }
    }
}