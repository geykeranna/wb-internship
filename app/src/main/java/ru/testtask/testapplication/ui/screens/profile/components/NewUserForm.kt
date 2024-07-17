package ru.testtask.testapplication.ui.screens.profile.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.input.InputField
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_INPUT_FIELDS_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_INPUT_FIELDS_PROFILE_SCREEN

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewUserForm(
    formFields: MutableList<FormField>,
    modifier: Modifier = Modifier,
) {
    val height = formFields.size * (HEIGHT_INPUT_FIELDS_PROFILE_SCREEN + SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN)

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = VERTICAL_PADDING_INPUT_FIELDS_PROFILE_SCREEN.dp)
            .heightIn(
                min = height.dp,
                max = height.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN.dp)
    ) {
        items(formFields.size) {
            InputField(
                modifier = Modifier.height(HEIGHT_INPUT_FIELDS_PROFILE_SCREEN.dp),
                state = formFields[it].value,
                placeholder = formFields[it].placeholder
            )
        }
    }
}