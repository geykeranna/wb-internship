package ru.testtask.testapplication.ui.screens.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.cards.events.EventCardsList
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.text.ExpandableText
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.theme.NeutralWeakColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun DetailCommunityScreen(
    modifier: Modifier = Modifier,
    id: String = "",
    navController: NavController
) {
    val detailInfo = CommunityData.shimmerData

    TopBar(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        iconLeft = R.drawable.ic_chevron_left,
        text = detailInfo.label,
        onLeftIconClick = { navController.navigate(Screen.Community.route) }
    )

    LazyColumn (
        modifier = Modifier
            .padding(horizontal = 28.dp)
            .padding(top = 62.dp)
    ){
        item {
            ExpandableText(
                modifier = Modifier,
                text = detailInfo.description,
                expandText = "...",
                style = MaterialTheme.typography.metadata1
                    .copy(color = NeutralWeakColor, lineHeight = 20.sp),
                maxLinesCollapsed = 13,
                collapseText = "Скрыть",
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