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
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.wb.ui.ui.screens.events.main.components.MainEventScreenContent
import ru.wb.ui.ui.screens.events.main.components.MainEventScreenSearch

@Composable
internal fun MainEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainEventsScreenViewModel = koinViewModel()
) {
    val events by viewModel.getAllDataFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val search by viewModel.getSearchStringFlow().collectAsStateWithLifecycle()
    val community by viewModel.getDataCommunityFlow().collectAsStateWithLifecycle()
    val selectedChips by viewModel.getChipsFlow().collectAsStateWithLifecycle()
    val allChipsList = viewModel.getAllChipsList()

    Scaffold(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
        topBar = {
            TopBarMain(
                modifier = Modifier.padding(top = 10.dp),
                inputText = search,
            ) { input ->
                viewModel.obtainEvent(MainEventsScreenViewModel.Event.OnSearch(input))
            }
        },
        bottomBar = {}
    ) { padding ->
        when {
            search.isEmpty() -> {
                MainEventScreenContent(
                    modifier = modifier.padding(padding),
                    events = events,
                    state = state,
                    community = community,
                    selectedChips = selectedChips,
                    allChipsList = allChipsList,
                    onSelect = { selected ->
                        viewModel.obtainEvent(MainEventsScreenViewModel.Event.OnSelectValue(selected))
                    },
                    onNavigate = {id -> navController.navigate(Screen.EVENT_DETAIL.route + "/${id}")}
                )
            }
            else -> {
                MainEventScreenSearch(
                    modifier = modifier.padding(padding),
                    events = events,
                    state = state,
                    community = community,
                    onNavigate = {id -> navController.navigate(Screen.EVENT_DETAIL.route + "/${id}")}
                )
            }
        }
    }
}