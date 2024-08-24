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
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.toolbars.TopBarCustom
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.cards.events.EventCardsList
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON

@Composable
internal fun MyEventsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MyEventScreenViewModel = koinViewModel()
) {
    val events by viewModel.getExpectedDataListFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()

    TopBarCustom(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp)
        ,
        label = Screen.MY_EVENTS.label,
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            navController.popBackStack()
        }
    )

    BaseScreen(
        modifier = modifier,
        state = state,
    ) {
        EventCardsList(
            itemsList = events,
            onNavigate = { }
        )
    }
}