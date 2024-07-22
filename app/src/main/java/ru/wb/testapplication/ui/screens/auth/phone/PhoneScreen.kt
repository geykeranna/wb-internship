package ru.wb.testapplication.ui.screens.auth.phone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.testapplication.R
import ru.wb.testapplication.ui.component.button.AnimatedCustomButton
import ru.wb.testapplication.ui.component.input.InputNumberField
import ru.wb.testapplication.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.utils.Constants.HEIGHT_BUTTON_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_BUTTON_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_FIELD_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_LOGIN_SCREEN
import ru.wb.testapplication.ui.screens.auth.components.TextFieldInfo

@Composable
fun PhoneScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: PhoneScreenViewModel = koinViewModel()
    Column(
        modifier = modifier
            .padding(top = TOP_PADDING_LOGIN_SCREEN.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TextFieldInfo(
            modifier = Modifier,
            titleText = stringResource(R.string.label_screens_phone),
            descriptionText = stringResource(R.string.description_screens_phone),
        )
        InputNumberField(
            modifier = Modifier
                .padding(top = TOP_PADDING_FIELD_IN_LOGIN_SCREEN.dp)
                .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp),
            onChange = {phone -> viewModel.onChangePhoneNumber(phone)},
            selectedPhoneCountryCode = viewModel.getSelectedPhoneCode().collectAsState().value,
            phone = viewModel.getPhoneNumber().collectAsState().value,
            phoneCountryCodeList = viewModel.getPhoneCountryCodeList().collectAsState().value,
            onSelectedPhoneCountryCode = {value -> viewModel.setSelectCode(value)}
        ){
            if(viewModel.getValidateState()){
                navController.navigate(Screen.PinCode.route)
            }
        }

        AnimatedCustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp)
                .padding(top = TOP_PADDING_BUTTON_IN_LOGIN_SCREEN.dp)
                .height(HEIGHT_BUTTON_LOGIN_SCREEN.dp),
            label = stringResource(R.string.button_label_screens_phone_continue),
            onClick = {
                navController.navigate(Screen.PinCode.route)
            },
            disabled = !viewModel.getValidateState()
        )
    }
}