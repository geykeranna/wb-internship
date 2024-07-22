package ru.wb.testapplication.ui.screens.community.community

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.testapplication.ui.component.cards.community.CommunityCardList
import ru.wb.testapplication.ui.component.input.SearchBar
import ru.wb.testapplication.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
import ru.wb.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON

@Composable
fun CommunityScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: CommunityViewModel = koinViewModel()
    val itemsList = viewModel.getData().collectAsState().value
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