package ru.wb.ui.ui.screens.startscreens.interests

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.usecases.common.GetChipsInterestUseCase
import ru.wb.domain.usecases.common.SetChipsInterestUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.PutUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class InterestsScreenViewModel(
    idUser: String,
    private val getUser: GetUserDataUseCase,
    private val setUser: PutUserDataUseCase,
    private val getOptions: GetChipsInterestUseCase,
    private val setChips: SetChipsInterestUseCase,
) : BaseViewModel<InterestsScreenViewModel.Event>(){
    private val _interestsOption = MutableStateFlow<List<String>>(listOf())
    private val interestsOption: StateFlow<List<String>> = _interestsOption

    private val _userData = MutableStateFlow(UserData.defaultObject)
    private val userData: StateFlow<UserData> = _userData

    private val _selectedInterests = MutableStateFlow<List<String>>(listOf())
    private val selectedInterests: StateFlow<List<String>> = _selectedInterests

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted(idUser = idUser))
    }

    fun getOptions(): StateFlow<List<String>> = interestsOption

    fun getSelected(): StateFlow<List<String>> = selectedInterests

    fun getState(): StateFlow<BaseState> = state

    private fun fetchData(idUser: String = "") = viewModelScope.launch {
        _state.emit(BaseState.LOADING)

        getOptions.execute().collect { newValue ->
            when(newValue) {
                is LoadState.Success -> { _interestsOption.emit(newValue.data) }
                is LoadState.Error -> _state.emit(BaseState.ERROR)
                else -> {}
            }
        }
        if(idUser.isNotEmpty()) {
            getUser.execute(idUser).collect { userData ->
                when(userData) {
                    is LoadState.Success -> {
                        _selectedInterests.emit(userData.data.tags)
                        _userData.emit(userData.data)
                    }
                    is LoadState.Error -> _state.emit(BaseState.ERROR)
                    else -> {}
                }
            }
        }

        joinAll()
        _state.emit(BaseState.SUCCESS)
    }

    private fun setupData(idUser: String) = viewModelScope.launch {
        when {
            idUser.isNotEmpty() -> setUser.execute(userData.value.copy(tags = selectedInterests.value))
            else -> setChips.execute(selectedInterests.value)
        }
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
        class OnLoadingStarted(val idUser: String = "") : Event()
        class OnEnterClick(val idUser: String = "") : Event()
        class OnSelect(val selected: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                fetchData(event.idUser)
            }
            is Event.OnEnterClick -> {
                setupData(event.idUser)
            }
            is Event.OnSelect -> {
                setSelected(event.selected)
            }
        }
    }
}