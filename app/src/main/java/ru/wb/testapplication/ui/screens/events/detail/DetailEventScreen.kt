package ru.wb.testapplication.ui.screens.events.detail

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
import ru.wb.testapplication.R
import ru.wb.domain.model.UserData
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.wb.testapplication.ui.screens.events.components.ButtonState
import ru.wb.testapplication.ui.screens.events.components.DetailData
import ru.wb.testapplication.ui.screens.events.components.FullScreenImageDialog
import ru.wb.testapplication.ui.theme.BrandDefaultColor

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
                detailInfo.usersList.add(UserData.defaultObject)
            }
            ButtonState.PRESSED.id -> {
                stateBnt = ButtonState.UNPRESSED.id
                detailInfo.usersList.remove(UserData.defaultObject)
            }
            ButtonState.UNPRESSED.id -> {
                stateBnt = ButtonState.PRESSED.id
                detailInfo.usersList.add(UserData.defaultObject)
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