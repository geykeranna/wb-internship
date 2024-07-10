package ru.testtask.testapplication.ui.component.cards.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.ui.component.navigation.Screen

@Composable
fun EventCardsList(
    modifier: Modifier = Modifier,
    itemsList: List<EventData>,
    navController: NavController,
    sorted: SORTBY = SORTBY.NO_SORT,
    height: Int = 104
) {
    val listItems = when (sorted) {
        SORTBY.NO_ACTIVE -> itemsList.filter { !it.active }
        SORTBY.ACTIVE -> itemsList.filter { it.active }
        else -> itemsList
    }

    LazyColumn(
        modifier = modifier.heightIn(min = (listItems.size * height).dp, max = (listItems.size * height).dp + 10.dp),
        contentPadding = PaddingValues(top = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        items(listItems.size) { index ->
            if (itemsList[index].active) {
                EventCard(
                    title = listItems[index].name,
                    location = listItems[index].location.city,
                    date = listItems[index].date,
                    tagList = listItems[index].tagList,
                    onClick = { navController.navigate(Screen.EventsDetail.route + "/${listItems[index].id}") },
                    src = listItems[index].icon
                )
            } else {
                EventCardEnded(
                    title = listItems[index].name,
                    location = listItems[index].location.city,
                    date = listItems[index].date,
                    tagList = listItems[index].tagList,
                    onClick = { navController.navigate(Screen.EventsDetail.route + "/${listItems[index].id}") },
                    src = listItems[index].icon
                )
            }
        }
    }
}

enum class SORTBY {
    NO_SORT, ACTIVE, NO_ACTIVE
}