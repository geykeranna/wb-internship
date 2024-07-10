package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar


@Composable
fun MyEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val listByGroup: List<EventsByGroup> = EventsByGroup.shimmerDataList2

    TopBar(
        modifier = modifier
            .padding(horizontal = 16.dp)
        ,
        text = Screen.MyEvents.name,
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED)
                navController.popBackStack()
        }
    )

    LazyColumn(
        modifier = modifier
            .padding(top = 62.dp)
            .padding(horizontal = 24.dp)
    ) {
        item {
            EventListByGroup(
                modifier = Modifier,
                listByGroup = listByGroup,
                navController = navController
            )
        }
    }
}