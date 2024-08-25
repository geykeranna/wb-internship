package ru.wb.ui.ui.screens.events.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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

    TopBarDetail(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        title = detailInfo.name,
        onBackClick = {
            navController.popBackStack()
        }
    )

    BaseScreen(
        modifier = modifier,
        state = state,
    ){
        DetailData(
            modifier = modifier
                .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp)
                .padding(top = 58.dp),
            detailInfo = detailInfo,
        )

        Button(
            onClick = {
                detailViewModel.obtainEvent(
                    DetailEventScreenViewModel.Event.OnHandleGoingEvent(
                        id = id
                    )
                )
            }
        ) {
            Text(text = "Записаться на встречу")
        }
    }
}