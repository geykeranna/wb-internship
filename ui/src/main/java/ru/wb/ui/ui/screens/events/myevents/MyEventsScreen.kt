package ru.wb.ui.ui.screens.events.myevents

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.events.EventListByGroup
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON

@Composable
internal fun MyEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MyEventScreenViewModel = koinViewModel()
) {
    val expectedList by viewModel.getExpectedDataListFlow().collectAsStateWithLifecycle()
    val passedList by viewModel.getPassedDataListFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()

    TopBar(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp)
        ,
        text = Screen.MY_EVENTS.label,
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            navController.popBackStack()
        }
    )

    BaseScreen(
        modifier = modifier,
        state = state,
    ) {
        EventListByGroup(
            modifier = Modifier
                .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp)
                .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
            listByGroup = listOf(expectedList, passedList),
            navController = navController,
            tabsList = listOf(Group.EXPECTED.label, Group.PASSED.label)
        )
    }
}

private enum class Group(val label: String) {
    EXPECTED("Запланированы"),
    PASSED("Прошли")
}