package ru.testtask.testapplication.ui.component.cards.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.navigation.Screen

@Composable
fun CommunityCardList(
    modifier: Modifier = Modifier,
    itemsList: List<CommunityData>,
    onClick: () -> Unit = {},
    navController: NavController,
    height: Int = 104
) {
    LazyColumn(
        modifier = modifier.heightIn(min = (itemsList.size * height).dp, max = (itemsList.size * height).dp + 10.dp),
        contentPadding = PaddingValues(top = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(itemsList.size){ index ->
            CommunityCard(
                modifier = Modifier.clickable { onClick() },
                label = itemsList[index].label,
                onClick = { navController.navigate(Screen.CommunityDetail.route + "/${itemsList[index].id}") },
                countPeople = itemsList[index].countPeople,
                src = itemsList[index].icon
            )
        }
    }
}