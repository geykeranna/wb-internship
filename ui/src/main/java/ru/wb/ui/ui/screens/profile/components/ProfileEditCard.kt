package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.avatars.ProfileAvatar
import ru.wb.ui.ui.component.avatars.ProfileSize
import ru.wb.ui.ui.component.button.AnimatedCustomButton
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_BUTTON_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_BIG_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_AVATAR_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_BUTTON_PROFILE_SCREEN
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON

@Composable
fun ProfileEditCard(
    state: Boolean,
    formField: MutableList<FormField>,
    modifier: Modifier = Modifier,
    onValueChange: (index: Int, value: String) -> Unit = {_, _ -> },
    onClick: () -> Unit,
) {
    LazyColumn (
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_BIG_COMMON.dp)
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            ProfileAvatar(
                modifier = Modifier.padding(top = VERTICAL_PADDING_AVATAR_PROFILE_SCREEN.dp),
                size = ProfileSize.NORMAL,
                isFloatingVisible = true
            )
        }

        item {
            NewUserForm(
                formFields = formField,
                onValueChange = onValueChange
            )
        }

        item {
            AnimatedCustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = VERTICAL_PADDING_BUTTON_PROFILE_SCREEN.dp)
                    .height(HEIGHT_BUTTON_PROFILE_SCREEN.dp),
                label = stringResource(R.string.label_button_save),
                onClick = onClick,
                disabled = !state
            )
        }
    }
}