package ru.testtask.testapplication.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.data.model.CountryCodes
import ru.testtask.testapplication.ui.component.utils.PhoneNumberVisualTransformation
import ru.testtask.testapplication.ui.theme.NeutralActiveColor
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.NeutralOffWhiteColor
import ru.testtask.testapplication.ui.theme.bodyText1

@Composable
fun InputNumberField(
    modifier: Modifier = Modifier,
    onEnterClick: (number: String) -> Unit = {},
    placeholder: String = "000 000 00-00-00"
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldValue by remember {
        mutableStateOf("")
    }
    val phoneCountryCodeList = CountryCodes.shimmerData
    var selectedPhoneCountryCode by remember {
        mutableStateOf(phoneCountryCodeList.first())
    }
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable {
                    expanded = !expanded
                }
                .background(NeutralOffWhiteColor)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = selectedPhoneCountryCode.flagIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = selectedPhoneCountryCode.countryCode,
                style = MaterialTheme.typography.bodyText1,
                color = NeutralDisabledColor
            )
        }
        DropdownMenu(
            modifier = Modifier
                .background(NeutralOffWhiteColor),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ){
            phoneCountryCodeList.forEach { phoneCountryCode ->
                DropdownMenuItem(
                    modifier = Modifier
                        .background(NeutralOffWhiteColor),
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Icon(
                                painter = painterResource(id = phoneCountryCode.flagIcon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                            Text(
                                text = phoneCountryCode.countryCode,
                                style = MaterialTheme.typography.bodyText1,
                                color = NeutralDisabledColor
                            )
                        }
                    },
                    onClick = {
                        selectedPhoneCountryCode = phoneCountryCode
                        expanded = false
                    }
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(
            modifier = Modifier
                .focusRequester(focusRequester),
            value = textFieldValue,
            cursorBrush = SolidColor(Color.Transparent),
            onValueChange = {
                textFieldValue = it.take(9)
            },
            textStyle = MaterialTheme.typography.bodyText1.copy(
                color = NeutralActiveColor
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { onEnterClick(textFieldValue) }
            ),
            visualTransformation = PhoneNumberVisualTransformation(),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .background(NeutralOffWhiteColor)
                        .padding(8.dp)
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (textFieldValue.isEmpty()){
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.bodyText1,
                            color = NeutralDisabledColor
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}