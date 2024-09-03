package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_CHIPS

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ChipsGroup(
    data: List<ChipsData>,
    modifier: Modifier = Modifier,
    size: ChipsSize = ChipsSize.LARGE,
    selectedList: List<ChipsData> = listOf(),
    onChangeSelect: (newValue: ChipsData) -> Unit = {},
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS.dp),
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS.dp)
    ) {
        data.forEach { chip ->
            val isSelect = selectedList.contains(chip)

            ChipsItems(
                modifier = Modifier,
                item = chip,
                size = size,
                isSelect = isSelect,
                onSelect = onChangeSelect
            )
        }
    }
}
