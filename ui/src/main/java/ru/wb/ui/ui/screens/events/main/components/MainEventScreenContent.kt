package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
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
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun MainEventScreenContent(
    modifier: Modifier = Modifier,
    events: List<EventData> = listOf(),
    community: List<CommunityData> = listOf(),
    state: BaseState = BaseState.EMPTY,
    selectedChips: List<ChipsData> = listOf(),
    allChipsList: List<ChipsData> = listOf(),
    onSelect: (list: List<ChipsData>) -> Unit = {}
) {
    BaseScreen(
        modifier = modifier
            .padding(top = 74.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        state = state,
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 74.dp)
                .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                EventCardsList(
                    modifier = Modifier,
                    onNavigate = {},
                    itemsList = events,
                    size = EventSize.WIDE,
                )
            }

            item {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Близжайшие встречи",
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

            item {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Сообщества для тестировщиков",
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
                    text = "Другие встречи",
                    style = AppTheme.typography.heading2,
                    overflow = TextOverflow.Visible,
                    color = AppTheme.colors.neutralColorFont
                )

                ChipsGroup(
                    modifier = Modifier,
                    data = allChipsList,
                    mode = ChipsMode.MULTIPLE,
                    selectedList = selectedChips,
                    onChangeSelect = { selected -> onSelect(selected) }
                )
            }

            items (events.size) { index ->
                EventCard(
                    modifier = Modifier.fillMaxWidth(),
                    eventData = events[index],
                    size = EventSize.WIDE,
                    onClick = { },
                    src = events[index].icon
                )
            }
        }
    }
}