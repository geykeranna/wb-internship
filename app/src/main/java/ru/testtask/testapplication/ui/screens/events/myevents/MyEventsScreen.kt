package ru.testtask.testapplication.ui.screens.events.myevents

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.testtask.testapplication.R
import ru.testtask.testapplication.repository.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.screens.events.active.ActiveEventsScreenViewModel

@Composable
fun MyEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ActiveEventsScreenViewModel = koinViewModel()
) {
    val listByGroup: List<EventsByGroup> = viewModel.getData().collectAsState().value

    TopBar(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp)
        ,
        text = Screen.MyEvents.name,
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                navController.popBackStack()
            }
        }
    )

    EventListByGroup(
        modifier = Modifier
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        listByGroup = listByGroup,
        navController = navController
    )
}