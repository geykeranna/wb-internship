package ru.wb.ui.ui.screens.events.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.button.GradientButton
import ru.wb.ui.ui.component.toolbars.TopBarDetail
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.ui.ui.screens.events.detail.components.DetailData

@Composable
internal fun DetailEventScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailEventScreenViewModel = koinViewModel(parameters = { parametersOf(id) })
) {
    val detailInfo by detailViewModel.getDetailDataFlow().collectAsStateWithLifecycle()
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        topBar = {
            TopBarDetail(
                modifier = Modifier,
                title = detailInfo.name,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            GradientButton(
                text = "Записаться на встречу",
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                detailViewModel.obtainEvent(
                    DetailEventScreenViewModel.Event.OnHandleGoingEvent(
                        id = id
                    )
                )
            }
        }
    ) { padding ->
        BaseScreen(
            modifier = Modifier
                .padding(padding),
            state = state,
        ){
            DetailData(
                modifier = modifier,
                detailInfo = detailInfo,
            )
        }
    }
}