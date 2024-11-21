package ru.wb.ui.ui.screens.events.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.toolbars.TopBarMain
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.screens.auth.onevent.components.appointmentGetOptionsByParams
import ru.wb.ui.ui.screens.events.main.components.MainEventScreenContent
import ru.wb.ui.ui.screens.events.main.MainEventsScreenViewModel.Event
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun MainEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainEventsScreenViewModel = koinViewModel()
) {
    val stateScreen by viewModel.getContentStateFlow().collectAsStateWithLifecycle()
    val search by viewModel.getSearchStringFlow().collectAsStateWithLifecycle()
    val filteredContent by viewModel.getContentDataFlow().collectAsStateWithLifecycle()
    val staticContent by viewModel.getLabelContentDataFlow().collectAsStateWithLifecycle()
    val selectedChips by viewModel.getChipsFlow().collectAsStateWithLifecycle()
    val authState by viewModel.getAuthStateFlow().collectAsStateWithLifecycle()
    val allChipsList = viewModel.getAllChipsList()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBarMain(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
                inputText = search,
                onChangeValue = { input -> viewModel.obtainEvent(Event.OnSearch(input)) },
                onRightClick =  {
                    when {
                        authState -> navController.navigate(Screen.PROFILE_VIEW_INSIDE_DETAIL.route)
                        else -> navController.navigate(
                            Screen.APPOINTMENT_PHONE.route + appointmentGetOptionsByParams(
                                "Авторизация", "user"
                            )
                        )
                    }
                }
            )
        },
        containerColor = AppTheme.colors.neutralColorBackground
    ) { padding ->
        MainEventScreenContent(
            filteredContent = filteredContent,
            staticContent = staticContent,
            modifier = Modifier.padding(padding),
            selectedChips = selectedChips,
            allChipsList = allChipsList,
            stateScreen = stateScreen,
            onSelect = { selected ->
                viewModel.obtainEvent(Event.OnSelectValue(selected))
            },
            onAddCommunityClick = { idCommunity, idContent ->
                viewModel.obtainEvent(Event.OnChangeSubscribeState(idCommunity, idContent))
            },
            onNavigateToCommunityDetail = { id ->
                navController.navigate(Screen.COMMUNITY_DETAIL.route + "/$id")
            },
            onNavigateToEventDetail = { id ->
                navController.navigate(Screen.EVENT_DETAIL.route + "/$id")
            },
            onNavigateToUserDetail = { id ->
                navController.navigate(Screen.PROFILE_VIEW_OUTSIDE_DETAIL.route + "/$id")
            }
        )
    }
}