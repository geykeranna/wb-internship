package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActiveEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val searchState = rememberTextFieldState("")
    val listByGroup: List<EventsByGroup> = EventsByGroup.shimmerDataList1

    TopBar(
        modifier = Modifier.padding(horizontal = 24.dp),
        text = Screen.Events.name,
        iconRight = R.drawable.ic_plus,
    )

    SearchBar (
        modifier = Modifier
            .padding(top = 52.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        state = searchState
    )

    LazyColumn(
        modifier = modifier
            .padding(top = 122.dp)
            .padding(horizontal = 24.dp),
    ) {
        item {
            EventListByGroup(
                listByGroup = listByGroup,
                modifier = Modifier,
                navController = navController,
            )
        }
    }
}