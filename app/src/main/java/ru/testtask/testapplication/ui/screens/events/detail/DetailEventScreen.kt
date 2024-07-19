package ru.testtask.testapplication.ui.screens.events.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.testtask.testapplication.R
import ru.testtask.testapplication.repository.data.model.UserData
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.screens.events.components.ButtonState
import ru.testtask.testapplication.ui.screens.events.components.DetailData
import ru.testtask.testapplication.ui.screens.events.components.FullScreenImageDialog
import ru.testtask.testapplication.ui.theme.BrandDefaultColor

@Composable
fun DetailEventScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val detailViewModel: DetailEventScreenViewModel = koinViewModel(parameters = { parametersOf(id) })
    val detailInfo = detailViewModel.getDetailData().collectAsState().value
    val isMapFullScreen = remember { mutableStateOf(false) }
    var stateBnt by remember { mutableStateOf(ButtonState.DEFAULT.id) }
    val iconRight = when (stateBnt) {
            ButtonState.PRESSED.id -> R.drawable.ic_check_big
            else -> null
    }
    fun onClickButton() {
         when (stateBnt) {
            ButtonState.DEFAULT.id -> {
                stateBnt = ButtonState.PRESSED.id
                detailInfo.usersList.add(UserData.shimmerData)
            }
            ButtonState.PRESSED.id -> {
                stateBnt = ButtonState.UNPRESSED.id
                detailInfo.usersList.remove(UserData.shimmerData)
            }
            ButtonState.UNPRESSED.id -> {
                stateBnt = ButtonState.PRESSED.id
                detailInfo.usersList.add(UserData.shimmerData)
            }
            else -> {
                stateBnt = ButtonState.DEFAULT.id
            }
        }
    }

    FullScreenImageDialog(isMapFullScreen = isMapFullScreen)

    TopBar(
        modifier = modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        text = detailInfo.name,
        iconRight = iconRight,
        onRightIconClick = ::onClickButton,
        tintRightIcon = BrandDefaultColor,
        onLeftIconClick = {
            navController.popBackStack()
        }
    )

    DetailData(
        modifier = modifier,
        stateBnt = stateBnt,
        isMapFullScreen = isMapFullScreen,
        detailInfo = detailInfo,
        onClickButton = ::onClickButton
    )
}