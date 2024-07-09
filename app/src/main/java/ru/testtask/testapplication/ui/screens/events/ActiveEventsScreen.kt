package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.ui.component.cards.events.EventListByGroup
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.toolbars.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ActiveEventsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val searchState = rememberTextFieldState("")
    val listByGroup: List<EventsByGroup> = EventsByGroup.shimmerDataList1

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 24.dp)
    ) {
        item {
            TopBar(
                text = "Встречи",
                iconRight = R.drawable.ic_plus,
            )

            SearchBar (
                modifier = Modifier.padding(vertical = 16.dp),
                state = searchState
            )

            EventListByGroup(
                listByGroup = listByGroup,
                modifier = Modifier,
                navController = navController,
            )
        }
    }
}