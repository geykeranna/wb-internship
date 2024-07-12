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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileSize
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.input.InputField
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar

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
    val labelButton = "Сохранить"

    val heightInputField = 36

    val formFields = remember {
        mutableListOf(
            FormField(
                id = 0,
                name = "First name",
                placeholder = "Имя (обязательно)",
                required = true,
                value = TextFieldState("")
            ),
            FormField(
                id = 1,
                name = "Last name",
                placeholder = "Фамилия (опционально)",
                required = false,
                value = TextFieldState("")
            ),
        )
    }

    TopBar(
        modifier = modifier.padding(horizontal = 16.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = { onBackClick() },
        text = Screen.ProfileView.name
    )

    LazyColumn (
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 62.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            ProfileAvatar(
                modifier = Modifier.padding(top = 50.dp),
                size = ProfileSize.NORMAL,
                isFloatingVisible = true
            )
        }

        item {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .heightIn(
                        min = (formFields.size * (heightInputField + 12)).dp,
                        max = (formFields.size * (heightInputField + 12)).dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(formFields.size) {
                    InputField(
                        modifier = Modifier.height(heightInputField.dp),
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
                    .padding(top = 56.dp)
                    .height(52.dp),
                label = labelButton,
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