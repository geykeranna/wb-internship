package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.component.cards.community.CommunityCardList
import ru.wb.ui.ui.component.cards.events.EventCard
import ru.wb.ui.ui.component.cards.events.EventCardsList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun MainEventScreenSearch(
    modifier: Modifier = Modifier,
    events: List<EventData> = listOf(),
    community: List<CommunityData> = listOf(),
    state: BaseState = BaseState.EMPTY,
) {
    BaseScreen(
        modifier = modifier
            .padding(top = 74.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        state = state,
    ){
        LazyColumn(
            modifier = modifier
                .padding(top = 74.dp)
                .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            items (events.size) { index ->
                EventCard(
                    modifier = Modifier.fillMaxWidth(),
                    eventData = events[index],
                    size = EventSize.WIDE,
                    onClick = { },
                    src = events[index].icon
                )
            }

            item {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Сообщества",
                    style = AppTheme.typography.heading2,
                    overflow = TextOverflow.Visible,
                    color = AppTheme.colors.neutralColorFont
                )

                CommunityCardList(
                    modifier = Modifier,
                    itemsList = community,
                    onClick = {},
                    onNavigate = {}
                )
            }

            item {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Встречи для разработчиков",
                    style = AppTheme.typography.heading2,
                    color = AppTheme.colors.neutralColorFont,
                    overflow = TextOverflow.Visible,
                )

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