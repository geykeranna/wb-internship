package ru.testtask.testapplication.ui.component.cards.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.data.model.EventData

@Composable
fun EventCardsList(
    modifier: Modifier = Modifier,
    itemsList: List<EventData>,
    onClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.heightIn(min = (itemsList.size * 104).dp, max = (itemsList.size * 104).dp + 10.dp),
        contentPadding = PaddingValues(top = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        items(itemsList.size){index ->
            if (itemsList[index].active) {
                EventCard(
                    title = itemsList[index].name,
                    location = itemsList[index].location.city,
                    date = itemsList[index].date,
                    tagList = itemsList[index].tagList,
                    onClick = onClick,
                    src = itemsList[index].icon
                )
            } else {
                EventCardEnded(
                    title = itemsList[index].name,
                    location = itemsList[index].location.city,
                    date = itemsList[index].date,
                    tagList = itemsList[index].tagList,
                    onClick = onClick,
                    src = itemsList[index].icon
                )
            }
        }
    }
}