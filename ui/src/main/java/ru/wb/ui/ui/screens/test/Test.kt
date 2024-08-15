package ru.wb.ui.ui.screens.test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode

@Composable
fun Test() {
    val viewModel = TestViewModel()

    val selectedChipsList by viewModel.getChipsFlow().collectAsStateWithLifecycle()
    
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            ChipsGroup(
                chips = viewModel.chipsList,
            )
        }

        item {
            ChipsGroup(
                chips = viewModel.chipsList,
                selectedList = selectedChipsList,
                mode = ChipsMode.SINGLE
            ) { newList -> viewModel.onSelectChips(newList)}
        }

        item {
            ChipsGroup(
                chips = viewModel.chipsList,
                selectedList = selectedChipsList,
                mode = ChipsMode.MULTIPLE
            ) { newList -> viewModel.onSelectChips(newList) }
        }
    }
}