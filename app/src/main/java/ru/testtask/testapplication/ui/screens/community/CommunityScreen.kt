package ru.testtask.testapplication.ui.screens.community

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.cards.community.CommunityCardList
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.toolbars.TopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val searchState = rememberTextFieldState("")
    val itemsList: List<CommunityData> = listOf(
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
        CommunityData.shimmerData,
    )

    Column(
        modifier = modifier
            .padding(horizontal = 24.dp)
    ) {
        TopBar(
            text = "Сообщества",
        )

        SearchBar (
            modifier = Modifier.padding(vertical = 16.dp),
            state = searchState
        )

        CommunityCardList(
            modifier = Modifier,
            itemsList = itemsList,
            navController = navController
        )
    }
}