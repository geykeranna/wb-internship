package ru.wb.ui.ui.screens.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.cards.community.CommunityCardRowList
import ru.wb.ui.ui.component.cards.events.EventCardsRowList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileViewCard(
    userData: UserData,
    eventData: List<EventData>,
    communityData: List<CommunityData>,
    modifier: Modifier = Modifier,
    pageMode: ProfilePageMode = ProfilePageMode.VIEW_OUTSIDE,
    onBottomClick: () -> Unit = {},
    onNavigateToCommunityDetail: (id: String) -> Unit = {},
    onNavigateToEventDetail: (id: String) -> Unit = {}
) {
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ){
        item {
            ProfileViewInfoCard(
                modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
                userData = userData
            )
        }

        if (eventData.isNotEmpty()) {
            item {
                LabeledCard(
                    label = pageMode.eventLabelText,
                    modifierLabel = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp)
                ) {
                    EventCardsRowList(
                        modifier = Modifier,
                        onNavigate = onNavigateToEventDetail,
                        itemsList = eventData,
                        size = EventSize.THIN,
                    )
                }
            }
        }

        if (communityData.isNotEmpty()) {
            item {
                LabeledCard(
                    label = pageMode.communityLabelText,
                    modifierLabel = Modifier.padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp)
                ) {
                    CommunityCardRowList(
                        modifier = Modifier,
                        itemsList = communityData,
                        onClick = null,
                        onNavigate = onNavigateToCommunityDetail,
                    )
                }
            }
        }

        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clickable { onBottomClick() },
                text = pageMode.bottomBarText,
                textAlign = TextAlign.Center,
                color = AppTheme.colors.neutralColorText,
                style = AppTheme.typography.primary,
            )
        }
    }
}