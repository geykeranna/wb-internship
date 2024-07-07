package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.cards.visitors.VisitorsList
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.component.text.ExpandableText
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.theme.NaturalWeakColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun DetailEventScreen(
    modifier: Modifier = Modifier,
) {
    val detailInfo = EventData.shimmerData1
    val scroll = rememberScrollState()
    val usersCount = detailInfo.usersList.size
    val usersList = remember { detailInfo.usersList }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        TopBar(
            modifier = Modifier.padding(top = 16.dp),
            iconLeft = R.drawable.ic_chevron_left,
            text = detailInfo.name,
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical =  16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${detailInfo.date} - ${detailInfo.location.city} ${detailInfo.location.address}",
                style = MaterialTheme.typography.bodyText1.copy(color = NaturalWeakColor)
            )

            CustomChipsGroup(
                chipsList = detailInfo.tagList
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .padding(horizontal = 12.dp)
                .verticalScroll(scroll),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // заглушка
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp),
                painter = painterResource(R.drawable.defaultmap),
                contentDescription = "map"
            )

            ExpandableText(
                modifier = Modifier,
                text = detailInfo.description,
                expandText = "...",
                collapseText = "Скрыть",
                maxLinesCollapsed = 8,
                style = MaterialTheme.typography.metadata1.copy(color = NaturalWeakColor, lineHeight = 20.sp)
            )

            VisitorsList(
                visitorsList = usersList
            )
        }

        AnimatedCustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 12.dp),
            label = "Пойду на встречу!",
            onClick = {
                if (usersCount == usersList.size)
                    usersList.add(UserData.shimmerData)
            }
        )
    }
}