package ru.wb.ui.ui.screens.events.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.ui.R
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.cards.visitors.VisitorsList
import ru.wb.ui.ui.component.text.ExpandableText
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_USERS_LIST_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.component.utils.Constants.MAX_LINE_COLLAPSED_IN_EXPANDABLE_TEXT_DETAIL_EVENT_SCREEN
import ru.wb.ui.ui.theme.NeutralWeakColor
import ru.wb.ui.ui.theme.metadata1

@Composable
internal fun InfoEventCard(
    isMapFullScreen: MutableState<Boolean>,
    detailInfo: EventData,
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            // заглушка
            Surface(
                modifier = Modifier.height(HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp),
                onClick = { isMapFullScreen.value = true },
                color = Color.White
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp)),
                    painter = painterResource(R.drawable.defaultmap),
                    contentDescription = "map",
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        item {
            ExpandableText(
                modifier = Modifier,
                text = detailInfo.description,
                expandText = stringResource(R.string.expandable_text_expand_text),
                collapseText = stringResource(R.string.expandable_text_collapse_text),
                maxLinesCollapsed = MAX_LINE_COLLAPSED_IN_EXPANDABLE_TEXT_DETAIL_EVENT_SCREEN,
                style = MaterialTheme.typography.metadata1.copy(color = NeutralWeakColor, lineHeight = 20.sp)
            )
        }

        item {
            VisitorsList(
                modifier = Modifier.height(HEIGHT_USERS_LIST_DETAIL_EVENT_SCREEN.dp),
                visitorsList = detailInfo.usersList
            )
        }
    }
}