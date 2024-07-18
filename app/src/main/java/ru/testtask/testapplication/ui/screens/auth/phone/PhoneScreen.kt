package ru.testtask.testapplication.ui.screens.auth.phone

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.button.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.input.InputNumberField
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.utils.Constants.CONTENT_PADDING_TEXT_IN_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_BUTTON_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_IN_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TEXT_IN_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.TOP_PADDING_BUTTON_IN_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.TOP_PADDING_FIELD_IN_LOGIN_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.TOP_PADDING_LOGIN_SCREEN
import ru.testtask.testapplication.ui.theme.bodyText2
import ru.testtask.testapplication.ui.theme.heading2

@Composable
fun PhoneScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val stateEnterNumber = remember {
        mutableStateOf(false)
    }
    val phone = remember {
        mutableStateOf("")
    }

    LazyColumn(
        modifier = modifier
            .padding(top = TOP_PADDING_LOGIN_SCREEN.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        item{
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = HORIZONTAL_PADDING_TEXT_IN_LOGIN_SCREEN.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_TEXT_IN_LOGIN_SCREEN.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.label_screens_phone),
                    style = MaterialTheme.typography.heading2,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier,
                    text = stringResource(R.string.description_screens_phone),
                    style = MaterialTheme.typography.bodyText2,
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            InputNumberField(
                modifier = Modifier
                    .padding(top = TOP_PADDING_FIELD_IN_LOGIN_SCREEN.dp)
                    .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp),
                onEnterClick = {
                    if (stateEnterNumber.value){
                        navController.navigate(Screen.PinCode.route + "/${phone.value}")
                    }
                },
                onChange = { number ->
                    phone.value = number
                },
                onValidate = {
                    stateEnterNumber.value = it
                }
            )
        }

        item {
            AnimatedCustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp)
                    .padding(top = TOP_PADDING_BUTTON_IN_LOGIN_SCREEN.dp)
                    .height(HEIGHT_BUTTON_LOGIN_SCREEN.dp),
                label = stringResource(R.string.button_label_screens_phone_continue),
                onClick = {
                    navController.navigate(Screen.PinCode.route + "/${phone.value}")
                },
                disabled = !stateEnterNumber.value
            )
        }
    }
}