package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.toolbars.TopBar


@Composable
fun MyEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val listByGroup: List<EventsByGroup> = EventsByGroup.shimmerDataList2

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 24.dp)
    ) {
        item {
            TopBar(
                text = "Мои встречи",
                iconLeft = R.drawable.ic_chevron_left,
            )

            EventListByGroup(
                modifier = Modifier.padding(top = 16.dp),
                listByGroup = listByGroup,
                navController = navController
            )
        }
    }
}