package ru.testtask.testapplication.ui.component.cards.events

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
import ru.testtask.testapplication.ui.component.utils.Constants.CONTENT_PADDING_OF_EVENT_ITEM_LIST
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_EVENT_ITEM_LIST

@Composable
fun EventCardsList(
    modifier: Modifier = Modifier,
    itemsList: List<EventData>,
    navController: NavController,
    sorted: SORTBY = SORTBY.NO_SORT,
) {
    val listItems = when (sorted) {
        SORTBY.NO_ACTIVE -> itemsList.filter { !it.active }
        SORTBY.ACTIVE -> itemsList.filter { it.active }
        else -> itemsList
    }

    val height = (listItems.size * HEIGHT_OF_EVENT_ITEM_LIST).dp

    LazyColumn(
        modifier = modifier.heightIn(min = height, max = height),
        contentPadding = PaddingValues(top = CONTENT_PADDING_OF_EVENT_ITEM_LIST.dp),
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_EVENT_ITEM_LIST.dp)
    ) {
        items(listItems.size) { index ->
            if (itemsList[index].active) {
                EventCard(
                    eventData = itemsList[index],
                    onClick = { navController.navigate(Screen.EventsDetail.route + "/${listItems[index].id}") },
                    src = listItems[index].icon
                )
            } else {
                EventCardEnded(
                    eventData = itemsList[index],
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