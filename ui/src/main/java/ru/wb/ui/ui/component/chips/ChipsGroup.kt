package ru.wb.ui.ui.component.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_CHIPS

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ChipsGroup(
    data: List<ChipsData>,
    modifier: Modifier = Modifier,
    mode: ChipsMode = ChipsMode.NO_SELECT,
    selectedList: List<ChipsData> = listOf(),
    onChangeSelect: (list: List<ChipsData>) -> Unit = {}
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS.dp),
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS.dp)
    ) {
        data.forEach { chip ->
            val isSelect = selectedList.contains(chip)

            ChipsItems(
                item = chip,
                isSelect = isSelect
            ) {
                when (mode) {
                    ChipsMode.SINGLE -> {
                        onSelect(
                            isSelect = isSelect,
                            selectedList = listOf(),
                            unSelectedList = listOf(chip),
                            onChangeSelect = onChangeSelect
                        )
                    }
                    ChipsMode.MULTIPLE -> {
                        onSelect(
                            isSelect = isSelect,
                            selectedList = selectedList - chip,
                            unSelectedList = selectedList + chip,
                            onChangeSelect = onChangeSelect
                        )
                    }
                    else -> {}
                }
            }
        }
    }
}

private fun onSelect(
    isSelect: Boolean,
    selectedList: List<ChipsData>,
    unSelectedList: List<ChipsData>,
    onChangeSelect: (list: List<ChipsData>) -> Unit,
) {
    val newList = if (isSelect) selectedList else unSelectedList
    return onChangeSelect(newList)
}
