package ru.wb.ui.ui.screens.startscreens.interests.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.chips.ChipsGroup

@Composable
internal fun InterestsScreenMain(
    options: List<String>,
    modifier: Modifier = Modifier,
    selectedList: List<String> = listOf(),
    onChangeSelect: (newValue: String) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        item{
            InterestsScreenTitle (
                modifier = Modifier
            )
        }

        item {
            ChipsGroup (
                modifier = Modifier,
                data = options,
                selectedList = selectedList,
                onChangeSelect = onChangeSelect,
            )
        }
    }
}