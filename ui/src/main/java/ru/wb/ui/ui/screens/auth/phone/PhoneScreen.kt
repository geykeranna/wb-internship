package ru.wb.ui.ui.screens.auth.phone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.ui.ui.component.button.AnimatedCustomButton
import ru.wb.ui.ui.component.input.InputNumberField
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_BUTTON_LOGIN_SCREEN
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_IN_LOGIN_SCREEN
import ru.wb.ui.ui.component.utils.Constants.TOP_PADDING_BUTTON_IN_LOGIN_SCREEN
import ru.wb.ui.ui.component.utils.Constants.TOP_PADDING_FIELD_IN_LOGIN_SCREEN
import ru.wb.ui.ui.component.utils.Constants.TOP_PADDING_LOGIN_SCREEN
import ru.wb.ui.ui.screens.auth.components.TitleInfoWithDescription

@Composable
fun PhoneScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PhoneScreenViewModel = koinViewModel()
) {
    val phone by viewModel.getPhoneNumber().collectAsStateWithLifecycle()
    val selectedPhoneCountryCode by viewModel.getSelectedPhoneCode().collectAsStateWithLifecycle()
    val phoneCountryCodeList by viewModel.getPhoneCountryCodeList().collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(top = TOP_PADDING_LOGIN_SCREEN.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TitleInfoWithDescription(
            modifier = Modifier,
            titleText = stringResource(R.string.label_screens_phone),
            descriptionText = stringResource(R.string.description_screens_phone),
        )
        InputNumberField(
            modifier = Modifier
                .padding(top = TOP_PADDING_FIELD_IN_LOGIN_SCREEN.dp)
                .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp),
            selectedPhoneCountryCode = selectedPhoneCountryCode,
            phone = phone,
            phoneCountryCodeList = phoneCountryCodeList,
            onChange = { phone -> viewModel.obtainEvent(PhoneScreenViewModel.Event.OnEnterNumber(phone))},
            onSelectedPhoneCountryCode = {
                value -> viewModel.obtainEvent(PhoneScreenViewModel.Event.OnSelectCode(value))
            }
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