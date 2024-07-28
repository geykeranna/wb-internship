package ru.wb.ui.ui.component.input

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
import ru.wb.ui.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.ui.ui.component.utils.PhoneNumberVisualTransformation
import ru.wb.ui.ui.theme.NeutralActiveColor
import ru.wb.ui.ui.theme.NeutralDisabledColor
import ru.wb.ui.ui.theme.NeutralOffWhiteColor
import ru.wb.ui.ui.theme.bodyText1

@Composable
internal fun InputNumberTextField(
    phone: String,
    selectedPhoneCountryCode: CountryCodes,
    modifier: Modifier = Modifier,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

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