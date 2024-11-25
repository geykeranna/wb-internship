package ru.wb.ui.ui.screens.events.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.Content
import ru.wb.ui.ui.component.cards.community.CommunityCardRowList
import ru.wb.ui.ui.component.cards.events.EventCardsColumnList
import ru.wb.ui.ui.component.cards.events.EventCardsRowList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.cards.users.UsersRowCard
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON

@Composable
internal fun MainViewByContent(
    contentItem: Content,
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
                    modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
                    onNavigate = onNavigateToEventDetail,
                    itemsList = contentItem.eventList.orEmpty(),
                    size = EventSize.LARGE,
                )
            }
            !contentItem.communityList.isNullOrEmpty() -> {
                CommunityCardRowList(
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