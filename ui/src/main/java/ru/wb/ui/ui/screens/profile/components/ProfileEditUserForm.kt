package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.R
import ru.wb.ui.ui.component.input.InputField
import ru.wb.ui.ui.component.input.InputNumberTextField
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN

@Composable
internal fun ProfileEditUserForm(
    formFields: ProfileFormState,
    modifier: Modifier = Modifier,
    onValueChange: (key: Int, value: List<String>) -> Unit = {_, _ -> }
) {
    val modifierItems = Modifier.fillMaxWidth()
    Column (
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN.dp)
    ) {
        InputField(
            modifier = modifierItems,
            value = formFields.name,
            placeholder = stringResource(id = R.string.placeholder_first_name_text_edit_form),
            onChangeValue = { text ->
                onValueChange(0, listOf(text))
            },
        )

        InputNumberTextField(
            modifier = modifierItems,
            input = formFields.phone,
            selectedPhoneCountryCode = CountryCodes.defaultData.first(),
            isAccent = false,
            isByFullPlaceholder = true,
            onChange = { text ->
                onValueChange(1, listOf(text))
            },
        )

        InputField(
            modifier = modifierItems,
            value = formFields.location,
            placeholder = stringResource(id = R.string.placeholder_location_text_edit_form),
            onChangeValue = { text ->
                onValueChange(2, listOf(text))
            },
        )

        InputField(
            modifier = modifierItems,
            value = formFields.description,
            minLines = 2,
            placeholder = stringResource(id = R.string.placeholder_description_text_edit_form),
            onChangeValue = { text ->
                onValueChange(3, listOf(text))
            },
        )
    }
}