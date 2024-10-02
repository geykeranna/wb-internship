package ru.wb.ui.ui.screens.profile.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.profile.components.ProfileView
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreenViewModel.Event

@Composable
internal fun ProfileViewScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    idUser: String = "",
    viewModel: ProfileViewScreenViewModel = koinViewModel(parameters = { parametersOf(idUser) })
){
    val userData by viewModel.getUserFlow().collectAsStateWithLifecycle()
    val eventData by viewModel.getEventDataFlow().collectAsStateWithLifecycle()
    val communityData by viewModel.getCommunityDataFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val formField by viewModel.getFieldsValuesFlow().collectAsStateWithLifecycle()
    val selectedChips by viewModel.getChipsFlow().collectAsStateWithLifecycle()
    val socialMedia by viewModel.getSocialMediaFlow().collectAsStateWithLifecycle()
    val allChipsList = viewModel.getAllChipsList()
    val pageMode by viewModel.getPageModeFlow().collectAsStateWithLifecycle()

    ProfileView(
        modifier = modifier,
        userData = userData,
        eventData = eventData,
        communityData = communityData,
        state = state,
        pageMode = pageMode,
        allChipsList = allChipsList,
        socialMedia = socialMedia,
        selectedChips = selectedChips,
        onBackNavigate = { navController.popBackStack() },
        formField = formField,
        onPageModeChange = { newValue ->
            viewModel.obtainEvent(Event.OnChangePageMode(newValue))
        },
        onBottomClick = {},
        onChipLastItemClick = {
            navController.navigate(Screen.INTEREST.route + "/${userData.id}")
        },
        onSelectChip = { newValue ->
            viewModel.obtainEvent(Event.OnSelectValue(newValue))
        },
    ) { index, value ->
        viewModel.obtainEvent(
            Event.OnChangeFieldData(key = index, input = value)
        )
    }
}