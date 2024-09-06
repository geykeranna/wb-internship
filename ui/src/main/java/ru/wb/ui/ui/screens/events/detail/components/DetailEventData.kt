package ru.wb.ui.ui.screens.events.detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.avatars.CommunityAvatar
import ru.wb.ui.ui.component.avatars.UserAvatar
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.cards.LocationCard
import ru.wb.ui.ui.component.cards.Owner
import ru.wb.ui.ui.component.cards.OwnerCard
import ru.wb.ui.ui.component.cards.community.CommunitySize
import ru.wb.ui.ui.component.cards.events.EventCardsColumnList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.cards.events.LargeEventCard
import ru.wb.ui.ui.component.cards.visitors.AvatarsSize
import ru.wb.ui.ui.component.cards.visitors.VisitorsList
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_SPACE_BY_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailEventData(
    detailInfo: EventData,
    modifier: Modifier = Modifier,
    onNavigateUsersScreen: () -> Unit = {},
    onNavigateEventScreen: (id: String) -> Unit = {},
    onNavigateUserScreen: (id: String) -> Unit = {},
    onNavigateCommunityScreen: (id: String) -> Unit = {},
) {
    val isMapFullScreen = remember { mutableStateOf(false) }
    FullScreenImageDialog(isMapFullScreen = isMapFullScreen)

    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(VERTICAL_SPACE_BY_CONTENT_COMMON.dp)
    ) {
        item {
            LargeEventCard(
                eventData = detailInfo,
            )
        }

        item {
            Text(
                style = AppTheme.typography.secondary,
                text = detailInfo.description,
                overflow = TextOverflow.Visible
            )
        }

        item {
            OwnerCard(
                modifier = Modifier.clickable { onNavigateUserScreen(detailInfo.manager.id) },
                owner = Owner.USER,
                title = detailInfo.manager.name,
                description = detailInfo.manager.description
            ) {
                UserAvatar(
                    src = detailInfo.manager.icon,
                    sizeAvatar = AvatarsSize.SQUARE,
                )
            }
        }

        item {
            LocationCard(
                modifier = Modifier,
                data = detailInfo.location,
                isMapFullScreen = isMapFullScreen
            )
        }

        if (detailInfo.usersList.isNotEmpty()) {
            item {
                LabeledCard(
                    label = "Пойдут на встречу"
                ) {
                    VisitorsList(
                        modifier = Modifier.fillMaxWidth(),
                        visitorsList = detailInfo.usersList,
                        onClick = onNavigateUsersScreen
                    )
                }
            }
        }

        item {
            OwnerCard(
                modifier = Modifier.clickable { onNavigateCommunityScreen(detailInfo.sponsor.id) },
                owner = Owner.COMMUNITY,
                title = detailInfo.sponsor.label,
                description = detailInfo.sponsor.description
            ) {
                CommunityAvatar(
                    src = detailInfo.sponsor.icon,
                    size = CommunitySize.SMALL,
                    isVerified = detailInfo.sponsor.isVerified
                )
            }
        }

        if (detailInfo.recommendation.isNotEmpty()) {
            item {
                LabeledCard(
                    label = "Другие встречи сообщества"
                ) {
                    EventCardsColumnList(
                        modifier = Modifier,
                        onNavigate = onNavigateEventScreen,
                        itemsList = detailInfo.recommendation,
                        size = EventSize.THIN,
                    )
                }
            }
        }
    }
}