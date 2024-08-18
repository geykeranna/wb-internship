package ru.wb.ui.ui.screens.test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode
import ru.wb.ui.ui.component.chips.TagsChips

@Composable
fun Test() {
    val viewModel = TestViewModel()

    val selectedChipsSingleList by viewModel.getChipsSingleFlow().collectAsStateWithLifecycle()
    val selectedChipsMultipleList by viewModel.getChipsMultipleFlow().collectAsStateWithLifecycle()

    val mod = Modifier.padding(vertical = 10.dp)

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
            )
        }

        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
                selectedList = selectedChipsSingleList,
                mode = ChipsMode.SINGLE
            ) { newList -> viewModel.onSelectChipsSingle(newList)}
        }

        item {
            ChipsGroup(
                modifier = mod,
                data = viewModel.chipsList,
                selectedList = selectedChipsMultipleList,
                mode = ChipsMode.MULTIPLE
            ) { newList -> viewModel.onSelectChipsMultiple(newList) }
        }

        item {
            TagsChips(
                data = viewModel.chipsList,
                modifier = mod
            )
        }


    }
}