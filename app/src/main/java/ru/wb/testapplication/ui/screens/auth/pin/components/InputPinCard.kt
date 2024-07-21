package ru.wb.testapplication.ui.screens.auth.pin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.testapplication.R
import ru.wb.testapplication.ui.component.button.AnimatedCustomButton
import ru.wb.testapplication.ui.component.button.ButtonType
import ru.wb.testapplication.ui.component.input.InputPassField
import ru.wb.testapplication.ui.component.utils.Constants.HEIGHT_BUTTON_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_BUTTON_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_FIELD_IN_LOGIN_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.TOP_PADDING_LOGIN_SCREEN
import ru.wb.testapplication.ui.screens.auth.components.TextFieldInfo

@Composable
fun InputPinCard(
    phone: String,
    pin: String,
    modifier: Modifier = Modifier,
    onChange: (value: String) -> Unit = {},
    onClickPassAgain: () -> Unit = {},
    onEnter: () -> Unit = {},
) {
    Column (
        modifier = modifier
            .padding(top = TOP_PADDING_LOGIN_SCREEN.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        TextFieldInfo(
            titleText = stringResource(R.string.label_screens_pin),
            descriptionText = stringResource(R.string.description_screens_pin),
            moreInfo = phone
        )

        InputPassField(
            modifier = Modifier
                .padding(top = TOP_PADDING_FIELD_IN_LOGIN_SCREEN.dp)
                .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp),
            value = pin,
            onEnterClick = onEnter,
            onChange = onChange
        )

        AnimatedCustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HORIZONTAL_PADDING_IN_LOGIN_SCREEN.dp)
                .padding(top = TOP_PADDING_BUTTON_IN_LOGIN_SCREEN.dp)
                .height(HEIGHT_BUTTON_LOGIN_SCREEN.dp),
            label = stringResource(R.string.button_label_screens_pin_request_the_code_again),
            type = ButtonType.TEXT,
            onClick = onClickPassAgain
        )
    }
}