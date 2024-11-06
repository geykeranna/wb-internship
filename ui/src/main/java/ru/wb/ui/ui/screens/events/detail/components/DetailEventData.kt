package ru.wb.ui.ui.screens.events.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.R
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
import ru.wb.ui.ui.component.utils.noRippleClickable
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

        detailInfo.manager?.let { userData ->
            item {
                OwnerCard(
                    modifier = Modifier.noRippleClickable { onNavigateUserScreen(userData.id) },
                    owner = Owner.USER,
                    title = userData.name,
                    description = userData.description
                ) {
                    UserAvatar(
                        src = userData.icon,
                        sizeAvatar = AvatarsSize.SQUARE,
                    )
                }
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
                    label = stringResource(id = R.string.text_will_go_on_meet)
                ) {
                    VisitorsList(
                        modifier = Modifier.fillMaxWidth(),
                        visitorsList = detailInfo.usersList,
                        onClick = onNavigateUsersScreen
                    )
                }
            }
        }

        detailInfo.sponsor?.let { item ->
            item {
                OwnerCard(
                    modifier = Modifier.noRippleClickable { onNavigateCommunityScreen(item.id) },
                    owner = Owner.COMMUNITY,
                    title = item.label,
                    description = item.description
                ) {
                    CommunityAvatar(
                        src = item.icon,
                        size = CommunitySize.SMALL,
                        isVerified = item.isVerified
                    )
                }
            }
        }

        if (!detailInfo.recommendation.isNullOrEmpty()) {
            item {
                LabeledCard(
                    label = stringResource(id = R.string.text_another_meet_in_community)
                ) {
                    EventCardsColumnList(
                        modifier = Modifier,
                        onNavigate = onNavigateEventScreen,
                        itemsList = detailInfo.recommendation ?: listOf(),
                        size = EventSize.THIN,
                    )
                }
            }
        }
    }
}