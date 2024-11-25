package ru.wb.ui.ui.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.PASS_LENGTH_IN_PASS_FIELD

@Composable
internal fun DecorationBoxInputPassField(
    value: String,
    modifier: Modifier = Modifier,
    isInvalid: Boolean = false,
) {
    Row(
        modifier
            .fillMaxWidth()
            .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(PASS_LENGTH_IN_PASS_FIELD){
            PinCodeDot(value = value, index = it, isInvalid = isInvalid)
        }
    }
}