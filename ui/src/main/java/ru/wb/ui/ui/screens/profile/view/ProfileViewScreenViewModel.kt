package ru.wb.ui.ui.screens.profile.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.defaultChipsList
import ru.wb.ui.ui.screens.profile.components.ProfilePageMode
import ru.wb.ui.ui.screens.profile.components.ProfileFormState

internal class ProfileViewScreenViewModel(
    idUser: String,
    private val getUserData: GetUserDataUseCase,
    private val getEventsList: GetEventListUseCase,
    private val getCommunityList: GetCommunityListUseCase,
    private val getUserID: GetCurrentUserIDUseCase,
    private val setUserData: PostUserDataUseCase,
): BaseViewModel<ProfileViewScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.defaultObject)
    private val userData: StateFlow<UserData> = _userData

    private val _dataEventList = MutableStateFlow(listOf<EventData>())
    private val dataEventList: StateFlow<List<EventData>> = _dataEventList

    private val _dataCommunityList = MutableStateFlow(listOf<CommunityData>())
    private val dataCommunityList: StateFlow<List<CommunityData>> = _dataCommunityList

    private val _chipsData = MutableStateFlow(listOf<String>())
    private val chipsData: StateFlow<List<String>> = _chipsData

    private val _socialMedia = MutableStateFlow(List(10) { SocialMedia.defaultObject })
    private val socialMedia: StateFlow<List<SocialMedia>> = _socialMedia

    private val _pageMode = MutableStateFlow(ProfilePageMode.VIEW_OUTSIDE)
    private val pageMode: StateFlow<ProfilePageMode> = _pageMode

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    private val formFieldsValue = MutableStateFlow(
        ProfileFormState(
            name = userData.value.name,
            phone = userData.value.phone,
            tags = userData.value.tags,
            description = userData.value.description,
            location = userData.value.location,
            socials = userData.value.socialMedia,
            isShowCommunity = userData.value.isShowCommunity,
            isShowEvent = userData.value.isShowEvent,
            enableNotification = userData.value.enableNotification,
        )
    )

    init {
        obtainEvent(Event.OnLoadingStarted(idUser = idUser))
        when {
            idUser.isEmpty() -> _pageMode.value = ProfilePageMode.VIEW_INSIDE
            else -> _pageMode.value = ProfilePageMode.VIEW_OUTSIDE
        }
    }

    fun getFieldsValuesFlow(): StateFlow<ProfileFormState> = formFieldsValue

    fun getUserFlow(): StateFlow<UserData> = userData

    fun getSocialMediaFlow(): StateFlow<List<SocialMedia>> = socialMedia

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getEventDataFlow(): StateFlow<List<EventData>> = dataEventList

    fun getCommunityDataFlow(): StateFlow<List<CommunityData>> = dataCommunityList

    fun getChipsFlow(): StateFlow<List<String>> = chipsData

    fun getPageModeFlow(): StateFlow<ProfilePageMode> = pageMode

    fun getAllChipsList(): List<String> = defaultChipsList

    private fun setSocialData (index: String, url: String) {
        val existValue = formFieldsValue.value.socials.find { it.id == index }
        val newValue = existValue?.copy(url = url)
            ?: socialMedia.value.find { it.id == index }?.copy(url = url)
        newValue?.let { value ->
            val newSocialList = formFieldsValue.value.socials.map { socialMedia ->
                if (socialMedia.id == index) value
                else socialMedia
            }
            formFieldsValue.value.copy(socials = newSocialList)
        }
    }

    private fun setFieldData(key: Int, value: Any) {
        when (key) {
            0 -> {
                if (value is String) {
                    formFieldsValue.value = formFieldsValue.value.copy(name = value)
                }
            }
            1 -> {
                if (value is String) {
                    formFieldsValue.value = formFieldsValue.value.copy(phone = value)
                }
            }
            2 -> {
                if (value is String) {
                    formFieldsValue.value = formFieldsValue.value.copy(location = value)
                }
            }
            3 -> {
                if (value is String) {
                    formFieldsValue.value = formFieldsValue.value.copy(description = value)
                }
            }
            4 -> {
                if (value is List<*>) {
                    val newValue = value.filterIsInstance<String>()
                    formFieldsValue.value = formFieldsValue.value.copy(tags = newValue)
                }
            }
            5 -> {
                if (value is Pair<*, *>) {
                    setSocialData(index = value.first as String, url = value.second as String)
                }
            }
            6 -> {
                if (value is Boolean) {
                    formFieldsValue.value = formFieldsValue.value.copy(isShowCommunity = value)
                }
            }
            7 -> {
                if (value is Boolean) {
                    formFieldsValue.value = formFieldsValue.value.copy(isShowEvent = value)
                }
            }
            8 -> {
                if (value is Boolean) {
                    formFieldsValue.value = formFieldsValue.value.copy(enableNotification = value)
                }
            }
        }
    }

    private fun startLoading(idUser: String?) = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        var userId = idUser
        when {
            idUser.isNullOrEmpty() -> getUserID.execute().collect { userId = it }
        }
        getUserData.execute(id = userId).collect {
            when {
                it.id.isEmpty() -> BaseState.ERROR
                else -> {
                    _state.emit(BaseState.SUCCESS)
                    _userData.emit(it)
                }
            }
        }
        getEventsList.execute(idUser = userId).collect {
            _dataEventList.emit(it)
        }
        getCommunityList.execute(idUser = userId).collect {
            _dataCommunityList.emit(it)
        }
    }

    private fun sendData() = viewModelScope.launch {
        _userData.emit(userData.value.copy(
            name = formFieldsValue.value.name,
            phone = formFieldsValue.value.phone,
            location = formFieldsValue.value.location,
            description = formFieldsValue.value.description,
            tags = formFieldsValue.value.tags,
            isShowEvent = formFieldsValue.value.isShowEvent,
            isShowCommunity = formFieldsValue.value.isShowCommunity,
            enableNotification = formFieldsValue.value.enableNotification,
            socialMedia = formFieldsValue.value.socials,
        ))
        setUserData.execute(userData.value)
    }

    private fun onSelectItems(selectedList: String) = viewModelScope.launch {
        val newList = chipsData.value.toMutableList()
        newList.add(selectedList)
        _chipsData.emit(newList)
    }

    private fun onChangePageMode(newPageMode: ProfilePageMode) = viewModelScope.launch {
        when {
            pageMode.value == ProfilePageMode.EDIT && newPageMode == ProfilePageMode.VIEW_INSIDE -> {
                sendData()
            }
        }
        _pageMode.emit(newPageMode)
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val idUser: String?) : Event()
        class OnChangeFieldData(val key: Int, val input: Any) : Event()
        class OnSelectValue(val newValue: String): Event()
        class OnChangePageMode(val pageMode: ProfilePageMode): Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(idUser = event.idUser)
            }
            is Event.OnSelectValue -> {
                onSelectItems(event.newValue)
            }
            is Event.OnChangeFieldData -> {
                setFieldData(
                    key = event.key,
                    value = event.input,
                )
            }
            is Event.OnChangePageMode -> {
                onChangePageMode(event.pageMode)
            }
        }
    }
}