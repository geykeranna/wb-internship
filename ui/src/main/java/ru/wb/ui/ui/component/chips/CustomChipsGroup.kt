package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_CHIPS
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_CHIPS
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_LINE_CHIPS_GROUP
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun CustomChipsGroup(
    chipsList: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.height(HEIGHT_OF_LINE_CHIPS_GROUP.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS.dp)
    ) {
        items(chipsList.size) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_OF_CHIPS.dp))
                    .background(AppTheme.colors.brandColorBackground)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    text = chipsList[it],
                    maxLines = 1,
                    color = AppTheme.colors.brandColorDarkMode,
                    style = AppTheme.typography.metadata3
                )
            }
        }
    }
}
