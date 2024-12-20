package ru.wb.ui.ui.screens.community.community
//
//import androidx.compose.foundation.layout.padding
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//import androidx.navigation.NavController
//import org.koin.androidx.compose.koinViewModel
//import ru.wb.ui.ui.component.cards.community.CommunityCardRowList
//import ru.wb.ui.ui.component.input.SearchBar
//import ru.wb.ui.ui.component.navigation.Screen
//import ru.wb.ui.ui.component.toolbars.TopBarCustom
//import ru.wb.ui.ui.base.BaseScreen
//import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
//import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_COMMON
//import ru.wb.ui.ui.component.utils.Constants.VERTICAL_PADDING_SEARCH_BAR_COMMON
//
//@Composable
//internal fun CommunityScreen(
//    navController: NavController,
//    modifier: Modifier = Modifier,
//    viewModel: CommunityViewModel = koinViewModel()
//) {
//    val itemsList by viewModel.getDataFlow().collectAsStateWithLifecycle()
//    val searchValue by viewModel.getSearchTextFlow().collectAsStateWithLifecycle()
//    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
//
//    TopBarCustom(
//        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_COMMON.dp),
//        label = Screen.COMMUNITY.label,
//    )
//
//    SearchBar (
//        modifier = modifier
//            .padding(top = 52.dp)
//            .padding(
//                vertical = VERTICAL_PADDING_SEARCH_BAR_COMMON.dp,
//                horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp
//            ),
//        value = searchValue,
//        onChangeValue = { value ->
//            viewModel.obtainEvent(CommunityViewModel.Event.OnInputSearchField(value))
//        }
//    )
//
//    BaseScreen(
//        modifier = Modifier,
//        state = state
//    ){
//        CommunityCardRowList(
//            modifier = modifier
//                .padding(top = 122.dp)
//                .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp),
//            itemsList = itemsList,
//        )
//    }
//}