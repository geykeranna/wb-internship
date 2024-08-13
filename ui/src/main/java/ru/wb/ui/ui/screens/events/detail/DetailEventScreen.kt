package ru.wb.ui.ui.screens.events.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.R
import ru.wb.ui.ui.component.toolbars.TopBar
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.ui.ui.screens.events.components.ButtonState
import ru.wb.ui.ui.screens.events.components.DetailData
import ru.wb.ui.ui.screens.events.components.FullScreenImageDialog
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailEventScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    detailViewModel: DetailEventScreenViewModel = koinViewModel(parameters = { parametersOf(id) })
) {
    val detailInfo by detailViewModel.getDetailDataFlow().collectAsStateWithLifecycle()
    val isMapFullScreen = remember { mutableStateOf(false) }
    val stateBnt by detailViewModel.getBntStateFlow().collectAsStateWithLifecycle()
    val state by detailViewModel.getStateFlow().collectAsStateWithLifecycle()
    val iconRight = when (stateBnt) {
        ButtonState.PRESSED.id -> R.drawable.ic_check_big
        else -> null
    }

    FullScreenImageDialog(isMapFullScreen = isMapFullScreen)

    TopBar(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        text = detailInfo.name,
        iconRight = iconRight,
        onRightIconClick = {
            detailViewModel.obtainEvent(
                DetailEventScreenViewModel.Event.OnHandleGoingEvent(
                    id = id
                )
            )
        },
        tintRightIcon = AppTheme.colors.brandColorDefault,
        onLeftIconClick = {
            navController.popBackStack()
        }
    )

    BaseScreen(
        modifier = modifier,
        state = state,
    ){
        DetailData(
            modifier = modifier,
            stateBnt = stateBnt,
            isMapFullScreen = isMapFullScreen,
            detailInfo = detailInfo,
            onClickButton = {
                detailViewModel.obtainEvent(
                    DetailEventScreenViewModel.Event.OnHandleGoingEvent(
                        id = id
                    )
                )
            }
        )
    }
}