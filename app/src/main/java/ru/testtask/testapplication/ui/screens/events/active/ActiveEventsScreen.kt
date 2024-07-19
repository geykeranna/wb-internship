package ru.testtask.testapplication.ui.screens.events.active

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.testtask.testapplication.R
import ru.testtask.testapplication.repository.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON

@Composable
fun ActiveEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ActiveEventsScreenViewModel = koinViewModel()
) {
    val listByGroup: List<EventsByGroup> = viewModel.getData().collectAsState().value

    TopBar(
        modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
        text = Screen.Events.name,
        iconRight = R.drawable.ic_plus,
    )

    SearchBar (
        modifier = Modifier
            .padding(top = 52.dp)
            .padding(
                vertical = VERTICAL_PADDING_SEARCH_BAR_COMMON.dp,
                horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp
            ),
        value = ""
    )

    EventListByGroup(
        listByGroup = listByGroup,
        modifier = modifier.padding(top = 122.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        navController = navController,
    )
}