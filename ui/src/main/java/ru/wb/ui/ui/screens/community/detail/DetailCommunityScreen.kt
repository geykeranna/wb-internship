package ru.wb.ui.ui.screens.community.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.R
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.component.toolbars.TopBarCustom
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON

@Composable
internal fun DetailCommunityScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailCommunityScreenViewModel = koinViewModel(parameters = { parametersOf(id) })
) {
    val detailInfo by detailViewModel.getDetailDataFlow().collectAsStateWithLifecycle()
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()

    TopBarCustom(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        label = detailInfo.label,
        onLeftIconClick = { navController.navigate(Screen.COMMUNITY.route) }
    )

    BaseScreen(
        modifier = modifier,
        state = state,
    ) {
        DetailInfo(
            detailInfo = detailInfo,
            navController = navController
        )
    }
}