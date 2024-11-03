package ru.wb.ui.ui.screens.auth.onevent.name.components

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
    value: String,
    modifier: Modifier = Modifier,
    title: String  = "",
    disableEnter: Boolean = true,
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
                value = value,
                title = title,
                disableEnter = disableEnter,
                onBackClick = onBackClick,
                onChangeValue = onChangeValue,
                onEnterClick = onEnterClick,
            )
        }

        item {
            AppointmentBottomButtons(
                modifier = Modifier,
                primaryButtonText = stringResource(id = R.string.text_find_another),
                disableButton = disableEnter,
                onEnterClick = onEnterClick,
            )
        }
    }
}