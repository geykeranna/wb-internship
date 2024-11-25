package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.switch.HorizontalSwitchWithLabel

@Composable
internal fun ProfileEditSettingsValue (
    formField: ProfileFormState,
    modifier: Modifier = Modifier,
    onValueChange: (key: Int, value: Any) -> Unit = {_, _ -> },
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HorizontalSwitchWithLabel(
                label = stringResource(id = R.string.label_show_my_community),
                checked = formField.isShowCommunity,
                onCheckChange = {value -> onValueChange(6, value)}
            )
            HorizontalSwitchWithLabel(
                label = stringResource(id = R.string.label_show_my_events),
                checked = formField.isShowEvent,
                onCheckChange = {value -> onValueChange(7, value)}
            )
        }
        HorizontalSwitchWithLabel(
            label = stringResource(id = R.string.label_enable_notification),
            checked = formField.enableNotification,
            onCheckChange = {value -> onValueChange(8, value)}
        )
    }
}