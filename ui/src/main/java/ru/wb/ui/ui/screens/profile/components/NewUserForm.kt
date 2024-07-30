package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.input.InputField
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_INPUT_FIELDS_PROFILE_SCREEN

@Composable
internal fun NewUserForm(
    formFields: ScreenState,
    modifier: Modifier = Modifier,
    onValueChange: (key: Int, value: String) -> Unit = {_, _ -> }
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = VERTICAL_PADDING_INPUT_FIELDS_PROFILE_SCREEN.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN.dp)
    ) {
        InputField(
            modifier = Modifier,
            value = formFields.firstName,
            placeholder = stringResource(id = R.string.placeholder_first_name_text_edit_form),
            onChangeValue = { text ->
                onValueChange(0, text)
            },
        )

        InputField(
            modifier = Modifier,
            value = formFields.lastName,
            placeholder = stringResource(id = R.string.placeholder_last_name_text_edit_form),
            onChangeValue = { text ->
                onValueChange(1, text)
            },
        )
    }
}