package ru.wb.ui.ui.component.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.SIZE_OF_PASS_ITEMS
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun PinCodeDot(
    value: String,
    index: Int,
) {
    Column(
        modifier = Modifier
            .size(SIZE_OF_PASS_ITEMS.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedVisibility(
            visible = index !in value.indices,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(AppTheme.colors.neutralColorDivider)
            )
        }

        AnimatedVisibility(
            visible = index in value.indices,
        ) {
            Text(
                text = value.getOrElse(index) { ' ' }.toString(),
                style = AppTheme.typography.heading1,
                color = AppTheme.colors.neutralColorFont
            )
        }
    }
}