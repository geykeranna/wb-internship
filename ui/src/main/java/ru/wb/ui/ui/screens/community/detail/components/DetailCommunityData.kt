package ru.wb.ui.ui.screens.community.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.ui.ui.component.cards.LabeledCard
import ru.wb.ui.ui.component.cards.events.EventCardsList
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.cards.visitors.VisitorsList
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_SPACE_BY_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailCommunityData(
    detailInfo: CommunityData,
    modifier: Modifier = Modifier,
    btnState: ButtonsStateSub = ButtonsStateSub.DEFAULT,
    onNavigateUsersScreen: () -> Unit,
    onNavigateToEventDetail: (id: String) -> Unit = {}
) {
    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(VERTICAL_SPACE_BY_CONTENT_COMMON.dp),
    ){
        item {
            DetailCommunityInfo(
                modifier = Modifier,
                detailInfo = detailInfo,
            )
        }

        item {
            DetailCommunitySubButton (
                state = btnState
            )
        }

        item {
            Text (
                text = detailInfo.description,
                style = AppTheme.typography.secondary,
                color = AppTheme.colors.neutralColorFont,
                overflow = TextOverflow.Visible
            )
        }

        if (detailInfo.subscribers.isNotEmpty()) {
            item {
                LabeledCard(
                    label = "Подписаны"
                ) {
                    VisitorsList(
                        modifier = Modifier.fillMaxWidth(),
                        visitorsList = detailInfo.subscribers,
                        onClick = onNavigateUsersScreen
                    )
                }
            }
        }

        if (detailInfo.eventList.isNotEmpty()) {
            item {
                LabeledCard(
                    label = "Встречи"
                ) {
                    EventCardsList(
                        modifier = Modifier,
                        onNavigate = onNavigateToEventDetail,
                        itemsList = detailInfo.eventList,
                        size = EventSize.THIN,
                    )
                }
            }
        }
    }
}