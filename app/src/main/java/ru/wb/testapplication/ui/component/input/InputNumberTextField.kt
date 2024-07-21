package ru.wb.testapplication.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.testapplication.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER
import ru.wb.testapplication.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.testapplication.ui.component.utils.PhoneNumberVisualTransformation
import ru.wb.testapplication.ui.theme.NeutralActiveColor
import ru.wb.testapplication.ui.theme.NeutralDisabledColor
import ru.wb.testapplication.ui.theme.NeutralOffWhiteColor
import ru.wb.testapplication.ui.theme.bodyText1

@Composable
fun InputNumberTextField(
    phone: String,
    focusRequester: FocusRequester,
    selectedPhoneCountryCode: CountryCodes,
    modifier: Modifier = Modifier,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester),
        value = phone,
        cursorBrush = SolidColor(Color.Transparent),
        onValueChange = {
            val value = it
                .replace("\\D", "")
                .take(selectedPhoneCountryCode.mask.count { num -> num == CHAR_IN_MASK_FOR_NUMBER })
            onChange(value)
        },
        textStyle = MaterialTheme.typography.bodyText1.copy(
            color = NeutralActiveColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = { onEnterClick() },
        ),
        visualTransformation = PhoneNumberVisualTransformation(mask = selectedPhoneCountryCode.mask),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
                    .fillMaxWidth()
                    .background(NeutralOffWhiteColor)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (phone.isEmpty()){
                    Text(
                        text = selectedPhoneCountryCode.mask,
                        style = MaterialTheme.typography.bodyText1,
                        color = NeutralDisabledColor
                    )
                }
                innerTextField()
            }
        }
    )
}