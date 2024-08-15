package ru.wb.ui.ui.screens.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.ui.ui.component.chips.ChipsData

class TestViewModel: ViewModel() {
    private val _chipsData = MutableStateFlow(listOf(ChipsData(id="1", name = "Test1")))
    private val chipsData: StateFlow<List<ChipsData>> = _chipsData

    val chipsList = listOf(
        ChipsData(id="1", name = "Test1"),
        ChipsData(id="2", name = "Test2"),
        ChipsData(id="3", name = "Test3"),
        ChipsData(id="4", name = "Test4"),
        ChipsData(id="5", name = "Test5"),
    )

    fun getChipsFlow(): StateFlow<List<ChipsData>> = chipsData

    fun onSelectChips(list: List<ChipsData>) = viewModelScope.launch {
        _chipsData.emit(list)
    }
}