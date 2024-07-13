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
import ru.testtask.testapplication.ui.component.utils.Constants.CONTENT_PADDING_OF_COMMUNITY_ITEM_LIST
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_COMMUNITY_ITEM_LIST

@Composable
fun CommunityCardList(
    itemsList: List<CommunityData>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val heightOfList = (itemsList.size * HEIGHT_OF_COMMUNITY_ITEM_LIST).dp

    LazyColumn(
        modifier = modifier.heightIn(min = heightOfList, max = heightOfList),
        contentPadding = PaddingValues(top = CONTENT_PADDING_OF_COMMUNITY_ITEM_LIST.dp),
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_COMMUNITY_ITEM_LIST.dp)
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