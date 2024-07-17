package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_INFO_TEXT_CARD_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_ITEMS_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_SPACE_BY_CONTENT_COMMON
import ru.testtask.testapplication.ui.screens.events.components.ButtonByState
import ru.testtask.testapplication.ui.screens.events.components.ButtonState
import ru.testtask.testapplication.ui.screens.events.components.FullScreenImageDialog
import ru.testtask.testapplication.ui.screens.events.components.InfoEventCard
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.NeutralWeakColor
import ru.testtask.testapplication.ui.theme.bodyText1

@Composable
fun DetailEventScreen(
    id: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val detailInfo = EventData.shimmerData1
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
        modifier = Modifier
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

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON.dp)
            .padding(top = VERTICAL_PADDING_CONTENT_DETAIL_COMMON.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = VERTICAL_PADDING_ITEMS_COMMON.dp)
                .height(HEIGHT_INFO_TEXT_CARD_DETAIL_EVENT_SCREEN.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(VERTICAL_SPACE_BY_CONTENT_COMMON.dp)
        ) {
            Text(
                text = "${detailInfo.date} - ${detailInfo.location.city} ${detailInfo.location.address}",
                style = MaterialTheme.typography.bodyText1.copy(color = NeutralWeakColor)
            )

            CustomChipsGroup(
                chipsList = detailInfo.tagList
            )
        }

        InfoEventCard(
            isMapFullScreen = isMapFullScreen,
            detailInfo = detailInfo,
        )

        ButtonByState(
            state = stateBnt,
            onClickButton = ::onClickButton
        )
    }
}