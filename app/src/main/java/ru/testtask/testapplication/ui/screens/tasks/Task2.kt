package ru.testtask.testapplication.ui.screens.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.avatars.ProfileAvatar
import ru.testtask.testapplication.ui.component.avatars.ProfileSize
import ru.testtask.testapplication.ui.component.cards.community.CommunityCard
import ru.testtask.testapplication.ui.component.cards.events.EventCardsList
import ru.testtask.testapplication.ui.component.cards.visitors.VisitorsList
import ru.testtask.testapplication.ui.theme.heading2

@Composable
fun Task2() {
    val scroll = rememberScrollState()
    val modifier = Modifier.padding(vertical = 20.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .verticalScroll(scroll)
    ) {
        Text(modifier = modifier, text = "Собрать карточку встречи", style = MaterialTheme.typography.heading2)

        EventCardsList(
            itemsList = listOf(
                EventData.shimmerData1,
                EventData.shimmerData2,
            )
        )


        Text(modifier = modifier, text = "Собрать элемент (строчка с людьми) ", style = MaterialTheme.typography.heading2)
        
        VisitorsList(
            visitorsList = listOf(
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
            )
        )

        Text(modifier = modifier, text = "Собрать карточку сообщества", style = MaterialTheme.typography.heading2)
        
        CommunityCard(
            label = "Designa",
            countPeople = 10000,
        )

        Text(modifier = modifier, text = "Собрать компонент аватар из профиля", style = MaterialTheme.typography.heading2)

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ProfileAvatar(
                size = ProfileSize.LARGE
            )

            ProfileAvatar(
                size = ProfileSize.NORMAL,
                isFloatingVisible = true
            )
        }
    }
}