package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.wb.domain.model.ContentItems
import ru.wb.ui.ui.component.cards.community.CommunityCardList
import ru.wb.ui.ui.component.cards.events.EventCardsColumnList
import ru.wb.ui.ui.component.cards.events.EventCardsRowList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.cards.users.UsersRowCard

@Composable
internal fun MainViewByContent(
    contentItem: ContentItems,
    modifier: Modifier = Modifier,
    isFilter: Boolean = false,
    onNavigateToCommunityDetail: (id: String) -> Unit = {},
    onNavigateToEventDetail: (id: String) -> Unit = {},
    onNavigateToUserDetail: (id: String) -> Unit = {},
    onAddCommunityClick: (idCommunity: String, idContent: String) -> Unit = {_, _ -> },
) {
    Box(
        modifier = modifier,
    ) {
        when {
            !contentItem.eventList.isNullOrEmpty() && !isFilter -> {
                EventCardsRowList(
                    modifier = Modifier,
                    onNavigate = onNavigateToEventDetail,
                    itemsList = contentItem.eventList.orEmpty(),
                    size = when {
                        contentItem.label.isNotEmpty() -> EventSize.THIN
                        else -> EventSize.WIDE
                    },
                )
            }
            !contentItem.eventList.isNullOrEmpty() -> {
                EventCardsColumnList(
                    modifier = Modifier,
                    onNavigate = onNavigateToEventDetail,
                    itemsList = contentItem.eventList.orEmpty(),
                    size = EventSize.LARGE,
                )
            }
            !contentItem.communityList.isNullOrEmpty() -> {
                CommunityCardList(
                    modifier = Modifier,
                    itemsList = contentItem.communityList.orEmpty(),
                    onClick = { idCommunity ->
                        onAddCommunityClick(idCommunity, contentItem.id)
                    },
                    onNavigate = onNavigateToCommunityDetail,
                )
            }
            !contentItem.usersList.isNullOrEmpty() -> {
                UsersRowCard(
                    modifier = Modifier,
                    itemsList = contentItem.usersList.orEmpty(),
                    onNavigate = onNavigateToUserDetail
                )
            }
        }
    }
}