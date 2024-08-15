package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_CHIPS
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun ChipsItems(
    text: String,
    modifier: Modifier = Modifier,
    isSelect: Boolean = false,
    onSelect: () -> Unit = {}
){
    val background = when {
        isSelect -> AppTheme.colors.brandColorDefault
        else -> AppTheme.colors.brandColorLight
    }
    val textColor = when {
        isSelect -> AppTheme.colors.neutralColorBackground
        else -> AppTheme.colors.brandColorDefault
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_OF_CHIPS.dp))
            .background(background)
            .clickable { onSelect() }
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 10.dp)
                .align(Alignment.Center),
            text = text,
            maxLines = 1,
            color = textColor,
            style = AppTheme.typography.chips
        )
    }
}