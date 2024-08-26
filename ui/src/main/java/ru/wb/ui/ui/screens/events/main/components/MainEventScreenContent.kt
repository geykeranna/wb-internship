package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
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
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode

@Composable
internal fun MainEventScreenContent(
    modifier: Modifier = Modifier,
    events: List<EventData> = listOf(),
    community: List<CommunityData> = listOf(),
    state: BaseState = BaseState.EMPTY,
    selectedChips: List<ChipsData> = listOf(),
    allChipsList: List<ChipsData> = listOf(),
    onSelect: (list: List<ChipsData>) -> Unit = {},
    onAddCommunityClick: () -> Unit = {},
    onNavigateToCommunityDetail: (id: String) -> Unit = {},
    onNavigateToEventDetail: (id: String) -> Unit = {}
) {
    BaseScreen(
        modifier = modifier.padding(top = 20.dp),
        state = state,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            item {
                EventCardsList(
                    modifier = Modifier.padding(top = 20.dp),
                    onNavigate = onNavigateToEventDetail,
                    itemsList = events,
                    size = EventSize.WIDE,
                )
            }

            item {
                LabeledCard(
                    label = "Близжайшие встречи"
                ) {
                    EventCardsList(
                        modifier = Modifier,
                        onNavigate = onNavigateToEventDetail,
                        itemsList = events,
                        size = EventSize.THIN,
                    )
                }
            }

            item {
                LabeledCard(
                    label = "Сообщества для тестировщиков"
                ) {
                    CommunityCardList(
                        modifier = Modifier,
                        itemsList = community,
                        onClick = onAddCommunityClick,
                        onNavigate = onNavigateToCommunityDetail,
                    )
                }
            }

            item {
                LabeledCard(
                    label = "Другие встречи"
                ) {
                    ChipsGroup(
                        modifier = Modifier,
                        data = allChipsList,
                        mode = ChipsMode.MULTIPLE,
                        selectedList = selectedChips,
                        onChangeSelect = onSelect
                    )
                }
            }

            items (events.size) { index ->
                EventCard(
                    modifier = Modifier.fillMaxWidth(),
                    eventData = events[index],
                    size = EventSize.WIDE,
                    onNavigate = onNavigateToEventDetail,
                )
            }
        }
    }
}