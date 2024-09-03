package ru.wb.ui.ui.screens.community.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.toolbars.TopBarDetail
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.screens.community.detail.components.DetailCommunityData
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailCommunityScreen(
    idCommunity: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailCommunityScreenViewModel = koinViewModel(parameters = { parametersOf(idCommunity) })
) {
    val detailInfo by detailViewModel.getDetailDataFlow().collectAsStateWithLifecycle()
    val btnState by detailViewModel.getBtnStateBySubStatusFlow().collectAsStateWithLifecycle()
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()
    val labels by detailViewModel.getBtnStateBySubStatusFlow().collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
        containerColor = AppTheme.colors.neutralColorBackground,
        topBar = {
            TopBarDetail(
                modifier = Modifier.padding(bottom = 20.dp),
                title = labels.label,
                onLeftClick = { navController.popBackStack() }
            )
        },
    ) { padding ->
        BaseScreen(
            modifier = Modifier.padding(padding),
            state = state,
        ){
            DetailCommunityData(
                modifier = Modifier,
                detailInfo = detailInfo,
                btnState = btnState,
                onNavigateUsersScreen = { navController.navigate(Screen.USER_LIST.route + "/community $idCommunity") },
            ) { idCommunity ->
                navController.navigate(Screen.EVENT_DETAIL.route + "/$idCommunity")
            }
        }
    }
}