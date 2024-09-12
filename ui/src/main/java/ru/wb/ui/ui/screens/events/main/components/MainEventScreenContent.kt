package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.ContentItems
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON

@Composable
internal fun MainEventScreenContent(
    filteredContent: List<ContentItems>,
    staticContent: List<ContentItems>,
    stateScreen: BaseState,
    modifier: Modifier = Modifier,
    isSearch: Boolean = false,
    selectedChips: List<String> = listOf(),
    allChipsList: List<String> = listOf(),
    onSelect: (newValue: String) -> Unit = {},
    onNavigateToCommunityDetail: (id: String) -> Unit = {},
    onNavigateToEventDetail: (id: String) -> Unit = {},
    onNavigateToUserDetail: (id: String) -> Unit = {},
    onAddCommunityClick: (idCommunity: String, idContent: String) -> Unit = {_, _ -> },
) {
    BaseScreen(
        modifier = modifier.padding(top = 20.dp),
        state = stateScreen,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            if(!isSearch) {
                items(staticContent) { item ->
                    LabeledCard(
                        label = item.label,
                        modifierLabel = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
                    ) {
                        MainViewByContent(
                            contentItem = item,
                            modifier = Modifier,
                            isFilter = false,
                            onAddCommunityClick = onAddCommunityClick,
                            onNavigateToCommunityDetail = onNavigateToCommunityDetail,
                            onNavigateToEventDetail = onNavigateToEventDetail,
                            onNavigateToUserDetail = onNavigateToUserDetail,
                        )
                    }
                }

                item {
                    LabeledCard(
                        modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
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

            items(filteredContent) { item ->
                LabeledCard(
                    label = item.label
                ) {
                    MainViewByContent(
                        contentItem = item,
                        modifier = Modifier,
                        isFilter = true,
                        onAddCommunityClick = onAddCommunityClick,
                        onNavigateToCommunityDetail = onNavigateToCommunityDetail,
                        onNavigateToEventDetail = onNavigateToEventDetail,
                        onNavigateToUserDetail = onNavigateToUserDetail,
                    )
                }
            }
        }
    }
}