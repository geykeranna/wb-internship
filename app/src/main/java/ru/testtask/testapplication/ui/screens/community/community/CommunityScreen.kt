package ru.testtask.testapplication.ui.screens.community.community

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.testtask.testapplication.ui.component.cards.community.CommunityCardList
import ru.testtask.testapplication.ui.component.input.SearchBar
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON

@Composable
fun CommunityScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CommunityViewModel = koinViewModel()
) {
    val itemsList = viewModel.getData().collectAsState().value
    val isSearching = viewModel.getSearchState().collectAsState().value
    val searchState = viewModel.getSearchText().collectAsState().value

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
        text = Screen.Community.name,
    )

    SearchBar (
        modifier = modifier
            .padding(top = 52.dp)
            .padding(
                vertical = VERTICAL_PADDING_SEARCH_BAR_COMMON.dp,
                horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp
            ),
        value = searchState,
        onChangeValue = viewModel::onSearchTextChange
    )

    CommunityCardList(
        modifier = modifier
            .padding(top = 122.dp)
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
        itemsList = itemsList,
        navController = navController
    )
}