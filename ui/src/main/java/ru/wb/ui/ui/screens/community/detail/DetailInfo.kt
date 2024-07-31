package ru.wb.ui.ui.screens.community.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.wb.domain.model.CommunityData
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.events.EventCardsList
import ru.wb.ui.ui.component.text.ExpandableText
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.wb.ui.ui.theme.NeutralWeakColor
import ru.wb.ui.ui.theme.bodyText1
import ru.wb.ui.ui.theme.metadata1

@Composable
fun DetailInfo(
    detailInfo: CommunityData,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    LazyColumn (
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp)
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp)
    ){
        item {
            ExpandableText(
                modifier = Modifier,
                text = detailInfo.description,
                expandText = stringResource(R.string.expandable_text_expand_text),
                style = MaterialTheme.typography.metadata1
                    .copy(color = NeutralWeakColor, lineHeight = 20.sp),
                maxLinesCollapsed = 13,
                collapseText = stringResource(R.string.expandable_text_collapse_text),
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 16.dp),
                text = stringResource(R.string.text_community_meetings),
                color = NeutralWeakColor,
                style = MaterialTheme.typography.bodyText1
            )

            EventCardsList(
                itemsList = detailInfo.eventList,
                navController = navController
            )
        }
    }
}