package ru.wb.ui.ui.screens.events.active

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.component.cards.events.EventListByGroup
import ru.wb.ui.ui.component.input.SearchBar
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON

@Composable
internal fun ActiveEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ActiveEventsScreenViewModel = koinViewModel()
) {
    val allListByGroup by viewModel.getAllDataFlow().collectAsStateWithLifecycle()
    val activeListByGroup by viewModel.getActiveDataFlow().collectAsStateWithLifecycle()

    TopBar(
        modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
        text = Screen.EVENTS.label,
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
        modifier = modifier.padding(top = 122.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        navController = navController,
        listByGroup = listOf(allListByGroup, activeListByGroup),
        tabsList = listOf(Group.ALL.label, Group.ACTIVE.label)
    )
}

private enum class Group(val label: String) {
    ALL("Все встречи"),
    ACTIVE("Активные"),
}