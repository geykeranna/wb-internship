package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.cards.community.CommunityCardList
import ru.wb.ui.ui.component.cards.events.EventCard
import ru.wb.ui.ui.component.cards.events.EventCardsList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON

@Composable
internal fun MainEventScreenSearch(
    modifier: Modifier = Modifier,
    events: List<EventData> = listOf(),
    community: List<CommunityData> = listOf(),
    state: BaseState = BaseState.EMPTY,
    onNavigate: (id: String) -> Unit
) {
    BaseScreen(
        modifier = modifier.padding(top = 20.dp),
        state = state,
    ){
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            items (events.size) { index ->
                EventCard(
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                    eventData = events[index],
                    size = EventSize.WIDE,
                    onNavigate = onNavigate,
                )
            }

            item {
                LabeledCard(
                    label = "Сообщества"
                ) {
                    CommunityCardList(
                        modifier = Modifier,
                        itemsList = community,
                        onClick = {},
                        onNavigate = {}
                    )
                }
            }

            item {
                LabeledCard(
                    label = "Встречи для разработчиков"
                ) {
                    EventCardsList(
                        modifier = Modifier,
                        onNavigate = {},
                        itemsList = events,
                        size = EventSize.THIN,
                    )
                }
            }
        }
    }
}