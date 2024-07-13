package ru.testtask.testapplication.ui.screens.community

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.ui.component.cards.community.CommunityCardList
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON

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

    LazyColumn(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp)
    ) {
        item {
            TopBar(
                text = Screen.Community.name,
            )
        }

        item {
            SearchBar (
                modifier = Modifier.padding(vertical = VERTICAL_PADDING_SEARCH_BAR_COMMON.dp),
                state = searchState
            )
        }

        item {
            CommunityCardList(
                modifier = Modifier,
                itemsList = itemsList,
                navController = navController
            )
        }
    }
}