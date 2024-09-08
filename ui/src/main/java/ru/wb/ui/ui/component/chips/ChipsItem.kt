package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.background
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
import ru.wb.ui.ui.component.utils.onClick
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun ChipsItems(
    item: String,
    modifier: Modifier = Modifier,
    size: ChipsSize = ChipsSize.LARGE,
    isSelect: Boolean = false,
    onSelect: ((newValue: String) -> Unit)? = null
){
    val (background, textColor) = when {
        isSelect -> listOf(AppTheme.colors.brandColorDefault, AppTheme.colors.neutralColorBackground)
        else -> listOf(AppTheme.colors.neutralColorSecondaryBackground, AppTheme.colors.brandColorDefault)
    }

    val font = when (size) {
        ChipsSize.LARGE -> AppTheme.typography.subheading2
        ChipsSize.NORMAL -> AppTheme.typography.subheading5
        ChipsSize.SMALL -> AppTheme.typography.secondary
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_OF_CHIPS.dp))
            .background(background)
            .onClick(
                disabled = onSelect == null,
                onClick = { if(onSelect != null) onSelect(item) }
            )
    ) {
        Text(
            modifier = Modifier
                .padding(
                    top = size.paddingTop.dp,
                    bottom = size.paddingBottom.dp,
                    start = size.paddingLeft.dp,
                    end = size.paddingRight.dp,
                )
                .align(Alignment.Center),
            text = item,
            maxLines = 1,
            color = textColor,
            style = font
        )
    }
}