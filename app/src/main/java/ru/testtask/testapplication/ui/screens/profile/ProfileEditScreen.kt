package ru.testtask.testapplication.ui.screens.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileSize
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.input.InputField
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_BUTTON_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_INPUT_FIELDS_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_BIG_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_AVATAR_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_BUTTON_PROFILE_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_INPUT_FIELDS_PROFILE_SCREEN

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileEditScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onBackClick: () -> Unit = {
        if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED)
            navController.popBackStack()
    }
){
    val firstNameField = stringResource(R.string.text_form_field_first_name_profile_screen)
    val lastNameField = stringResource(R.string.text_form_field_last_name_profile_screen)

    val formFields = remember {
        mutableListOf(
            FormField(
                id = 0,
                name = "first_name",
                placeholder = firstNameField,
                required = true,
                value = TextFieldState("")
            ),
            FormField(
                id = 1,
                name = "last_name",
                placeholder = lastNameField,
                required = false,
                value = TextFieldState("")
            ),
        )
    }

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = { onBackClick() },
        text = Screen.ProfileView.name
    )

    LazyColumn (
        modifier = Modifier
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
            val height = formFields.size * (HEIGHT_INPUT_FIELDS_PROFILE_SCREEN + SPACE_BY_IN_INPUT_FIELDS_PROFILE_SCREEN)

            LazyColumn(
                modifier = Modifier
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

        item {
            AnimatedCustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = VERTICAL_PADDING_BUTTON_PROFILE_SCREEN.dp)
                    .height(HEIGHT_BUTTON_PROFILE_SCREEN.dp),
                label = stringResource(R.string.label_button_save),
                onClick = {
                    navController.navigate(Screen.Events.route)
                },
                disabled = !formFields
                    .filter { it.required }
                    .all { it.value.text.isNotEmpty() }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private data class FormField (
    val id: Int,
    val name: String,
    val placeholder: String,
    val required: Boolean,
    val value: TextFieldState
)