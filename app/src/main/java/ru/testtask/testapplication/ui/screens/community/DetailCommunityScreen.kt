package ru.testtask.testapplication.ui.screens.community

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
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.cards.events.EventCardsList
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.text.ExpandableText
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.theme.NeutralWeakColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun DetailCommunityScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val detailInfo = CommunityData.shimmerData

    TopBar(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        text = detailInfo.label,
        onLeftIconClick = { navController.navigate(Screen.Community.route) }
    )

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
                text = "Встречи сообщества",
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