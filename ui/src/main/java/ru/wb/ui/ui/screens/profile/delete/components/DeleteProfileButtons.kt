package ru.wb.ui.ui.screens.profile.delete.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.button.PrimaryButton
import ru.wb.ui.ui.component.button.SecondaryButton

@Composable
internal fun DeleteProfileButtons(
    modifier: Modifier = Modifier,
    onDeleteProfileClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_delete),
            onClick = onDeleteProfileClick,
        )
        
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_no_need),
            onClick = onCancelClick,
        )
    }
}