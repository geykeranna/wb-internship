package ru.wb.ui.ui.screens.startscreens.interests

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.usecases.common.GetChipsInterestUseCase
import ru.wb.domain.usecases.common.SetChipsInterestUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class InterestsScreenViewModel(
    private val getOptions: GetChipsInterestUseCase,
    private val setChips: SetChipsInterestUseCase,
) : BaseViewModel<InterestsScreenViewModel.Event>(){
    private val _interestsOption = MutableStateFlow<List<String>>(listOf())
    private val interestsOption: StateFlow<List<String>> = _interestsOption

    private val _selectedInterests = MutableStateFlow<List<String>>(listOf())
    private val selectedInterests: StateFlow<List<String>> = _selectedInterests

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getOptions(): StateFlow<List<String>> = interestsOption

    fun getSelected(): StateFlow<List<String>> = selectedInterests

    fun getState(): StateFlow<BaseState> = state

    private fun fetchData() = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getOptions.execute().collect { newValue ->
            when{
                newValue.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _interestsOption.emit(newValue)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    private fun setupData() = viewModelScope.launch {
        setChips.execute(selectedInterests.value)
    }

    private fun setSelected(newSelected: String) = viewModelScope.launch {
        _selectedInterests.emit(
            when{
                selectedInterests.value.contains(newSelected) -> selectedInterests.value - newSelected
                newSelected.isNotEmpty() -> selectedInterests.value + newSelected
                else -> selectedInterests.value
            }
        )
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnEnterClick : Event()
        class OnSelect(val selected: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                fetchData()
            }
            is Event.OnEnterClick -> {
                setupData()
            }
            is Event.OnSelect -> {
                setSelected(event.selected)
            }
        }
    }
}