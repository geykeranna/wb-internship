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
import ru.wb.ui.ui.component.toolbars.TopBarDetail
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.screens.events.components.ButtonByState
import ru.wb.ui.ui.screens.events.detail.components.DetailData
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailEventScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailEventScreenViewModel = koinViewModel(parameters = { parametersOf(id) })
) {
    val detailInfo by detailViewModel.getDetailDataFlow().collectAsStateWithLifecycle()
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()
    val btnState by detailViewModel.getBntStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
        containerColor = AppTheme.colors.neutralColorBackground,
        topBar = {
            TopBarDetail(
                modifier = Modifier,
                title = detailInfo.name,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            ButtonByState(
                modifier = Modifier.fillMaxWidth(),
                state = btnState,
                countPeople = detailInfo.vacantSeat
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
            modifier = Modifier.padding(padding),
            state = state,
        ){
            DetailData(
                modifier = modifier,
                detailInfo = detailInfo,
            )
        }
    }
}