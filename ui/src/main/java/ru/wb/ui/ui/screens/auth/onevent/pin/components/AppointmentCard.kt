package ru.wb.ui.ui.screens.auth.onevent.pin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.wb.ui.R
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentBottomButtons

@Composable
internal fun AppointmentCard(
    eventLabel: String,
    inputValue: String,
    modifier: Modifier = Modifier,
    title: String  = "",
    contextString: String = "",
    textButtonValue: String? = null,
    disableEnter: Boolean = false,
    disableTextButtonEnter: Boolean = false,
    invalidPin: Boolean = false,
    onTextButtonClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onEnterClick: () -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            AppointmentContent(
                modifier = Modifier,
                eventLabel = eventLabel,
                inputValue = inputValue,
                title = title,
                contextString = contextString,
                disableEnter = disableEnter,
                onBackClick = onBackClick,
                onChangeValue = onChangeValue,
                onEnterClick = onEnterClick,
                invalid = invalidPin,
            )
        }

        item {
            AppointmentBottomButtons(
                modifier = Modifier,
                primaryButtonText = stringResource(id = R.string.text_send_and_confirm_an_entry),
                secondaryButtonText = textButtonValue,
                disableButton = disableEnter,
                disableTextButton = disableTextButtonEnter,
                onEnterClick = onEnterClick,
                onTextButtonClick = onTextButtonClick,
            )
        }
    }
}