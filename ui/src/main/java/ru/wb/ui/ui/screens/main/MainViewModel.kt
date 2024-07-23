package ru.wb.ui.ui.screens.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.usecases.login.CheckAuthStateUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

class MainViewModel(
    private val getAuthState: CheckAuthStateUseCase
): BaseViewModel<MainViewModel.Event>() {
    private val _state = MutableStateFlow(false)
    private val state: StateFlow<Boolean> = _state

    fun getState() : StateFlow<Boolean> = state

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    private fun startLoading() = viewModelScope.launch {
        _state.value = getAuthState.execute()
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }
}