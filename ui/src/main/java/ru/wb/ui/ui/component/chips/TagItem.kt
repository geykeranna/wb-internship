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
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun TagItem(
    item: ChipsData,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_OF_CHIPS.dp))
            .background(AppTheme.colors.neutralColorSecondaryBackground)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 6.dp, vertical = 2.dp)
                .align(Alignment.Center),
            text = item.name,
            maxLines = 1,
            color = AppTheme.colors.brandColorDefault,
            style = AppTheme.typography.secondary
        )
    }
}