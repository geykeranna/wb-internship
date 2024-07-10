package ru.testtask.testapplication.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.testtask.testapplication.ui.component.button.text.AnimatedCustomTextButton
import ru.testtask.testapplication.ui.component.input.InputPassField
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.theme.bodyText2
import ru.testtask.testapplication.ui.theme.heading2

@Composable
fun PinCodeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    phone: String,
    label: String = "Введите номер телефона",
    description: String = "Отправили код на номер",
    labelButton: String = "Продолжить",
) {
    val stateEnterNumber = remember {
        mutableStateOf(true)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        item{
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Text(
                        modifier = Modifier,
                        text = label,
                        style = MaterialTheme.typography.heading2,
                        textAlign = TextAlign.Center
                    )
                }

                item {
                    Text(
                        modifier = Modifier,
                        text = description,
                        style = MaterialTheme.typography.bodyText2
                            .copy(lineHeight = 24.sp),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier,
                        text = phone,
                        style = MaterialTheme.typography.bodyText2
                            .copy(lineHeight = 24.sp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        item {
            InputPassField(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(horizontal = 24.dp),
                onEnterClick = {
                    stateEnterNumber.value = false
                }
            )
        }

        item {
            AnimatedCustomTextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 70.dp)
                    .height(52.dp),
                label = labelButton,
                onClick = {
                    navController.navigate(Screen.PinCode.route)
                },
                disabled = stateEnterNumber.value
            )
        }
    }
}

@Preview
@Composable
fun Preview(){
    PinCodeScreen(
        modifier = Modifier,
        navController = rememberNavController(),
        phone = "+700000000"
    )
}