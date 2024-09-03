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

@Composable
internal fun MainEventScreenContent(
    modifier: Modifier = Modifier,
    events: List<EventData> = listOf(),
    community: List<CommunityData> = listOf(),
    eventListState: BaseState = BaseState.EMPTY,
    communityListState: BaseState = BaseState.EMPTY,
    selectedChips: List<ChipsData> = listOf(),
    allChipsList: List<ChipsData> = listOf(),
    onSelect: (newValue: ChipsData) -> Unit = {},
    onAddCommunityClick: (id: String) -> Unit = {},
    onNavigateToCommunityDetail: (id: String) -> Unit = {},
    onNavigateToEventDetail: (id: String) -> Unit = {}
) {
    BaseScreen(
        modifier = modifier.padding(top = 20.dp),
        state = BaseState.SUCCESS,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            if (eventListState == BaseState.SUCCESS) {
                item {
                    EventCardsList(
                        modifier = Modifier,
                        onNavigate = onNavigateToEventDetail,
                        itemsList = events,
                        size = EventSize.WIDE,
                    )
                }
            }

            if (eventListState == BaseState.SUCCESS) {
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
            }

            if (communityListState == BaseState.SUCCESS) {
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
            }

            if (allChipsList.isNotEmpty()) {
                item {
                    LabeledCard(
                        label = "Другие встречи"
                    ) {
                        ChipsGroup(
                            modifier = Modifier,
                            data = allChipsList,
                            selectedList = selectedChips,
                            onChangeSelect = onSelect
                        )
                    }
                }
            }

            if (eventListState == BaseState.SUCCESS) {
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
}