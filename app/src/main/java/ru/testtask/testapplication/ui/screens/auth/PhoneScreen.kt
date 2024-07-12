package ru.testtask.testapplication.ui.screens.auth

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.input.InputNumberField
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.theme.bodyText2
import ru.testtask.testapplication.ui.theme.heading2

@Composable
fun PhoneScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    label: String = "Введите номер телефона",
    description: String = "Мы вышлем код подтверждения на указаный номер",
    labelButton: String = "Продолжить",
) {
    val stateEnterNumber = remember {
        mutableStateOf(true)
    }
    val phone = remember {
        mutableStateOf("")
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        item{
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = label,
                    style = MaterialTheme.typography.heading2,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier,
                    text = description,
                    style = MaterialTheme.typography.bodyText2,
                    textAlign = TextAlign.Center
                )
            }
        }

        item {
            InputNumberField(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(horizontal = 24.dp),
                onEnterClick = {
                    if (stateEnterNumber.value)
                        navController.navigate(Screen.PinCode.route + "/${phone.value}")
                },
                onChange = { number ->
                    phone.value = number
                },
                onValidate = {
                    stateEnterNumber.value = !it
                }
            )
        }

        item {
            AnimatedCustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 70.dp)
                    .height(52.dp),
                label = labelButton,
                onClick = {
                    navController.navigate(Screen.PinCode.route + "/${phone.value}")
                },
                disabled = stateEnterNumber.value
            )
        }
    }
}