package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_IN_TAGS_CHIPS

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagsChips(
    data: List<String>,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(SPACE_BY_IN_TAGS_CHIPS.dp),
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_IN_TAGS_CHIPS.dp),
    ) {
        data.forEach { item ->
            TagItem(item)
        }
    }
}