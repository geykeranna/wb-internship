package ru.testtask.testapplication.ui.screens.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import ru.testtask.testapplication.R
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.ui.component.button.default.AnimatedCustomButton
import ru.testtask.testapplication.ui.component.button.outlined.AnimatedCustomOutlinedButton
import ru.testtask.testapplication.ui.component.cards.visitors.VisitorsList
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.component.text.ExpandableText
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_INFO_TEXT_CARD_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_USERS_LIST_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.MAX_LINE_COLLAPSED_IN_EXPANDABLE_TEXT_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.testtask.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_ITEMS_COMMON
import ru.testtask.testapplication.ui.theme.BrandDefaultColor
import ru.testtask.testapplication.ui.theme.NeutralWeakColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun DetailEventScreen(
    modifier: Modifier = Modifier,
    id: String = "",
    navController: NavController
) {
    val detailInfo = EventData.shimmerData1
    val usersList = remember { detailInfo.usersList }
    val isMapFullScreen = remember { mutableStateOf(false) }
    FullScreenImageDialog(isMapFullScreen = isMapFullScreen)
    var stateBnt by remember { mutableStateOf(ButtonState.DEFAULT.id) }
    fun onClickButton() {
         when (stateBnt) {
            ButtonState.DEFAULT.id -> {
                stateBnt = ButtonState.PRESSED.id
                usersList.add(UserData.shimmerData)
            }
            ButtonState.PRESSED.id -> {
                stateBnt = ButtonState.UNPRESSED.id
                usersList.remove(UserData.shimmerData)
            }
            ButtonState.UNPRESSED.id -> {
                stateBnt = ButtonState.PRESSED.id
                usersList.add(UserData.shimmerData)
            }
            else ->
                stateBnt = ButtonState.DEFAULT.id
        }
    }

    TopBar(
        modifier = Modifier
            .padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_DETAIL_COMMON.dp),
        iconLeft = R.drawable.ic_chevron_left,
        text = detailInfo.name,
        iconRight = when (stateBnt) {
            ButtonState.PRESSED.id -> R.drawable.ic_check_big
            else -> null
        },
        onRightIconClick = { onClickButton() },
        tintRightIcon = BrandDefaultColor,
        onLeftIconClick = {
            if(navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED)
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "${detailInfo.date} - ${detailInfo.location.city} ${detailInfo.location.address}",
                style = MaterialTheme.typography.bodyText1.copy(color = NeutralWeakColor)
            )

            CustomChipsGroup(
                chipsList = detailInfo.tagList
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                // заглушка
                Surface(
                    modifier = Modifier.height(HEIGHT_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp),
                    onClick = { isMapFullScreen.value = true },
                    color = Color.White
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(CORNER_RADIUS_MAP_SCREEN_DETAIL_EVENT_SCREEN.dp)),
                        painter = painterResource(R.drawable.defaultmap),
                        contentDescription = "map",
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            item {
                ExpandableText(
                    modifier = Modifier,
                    text = detailInfo.description,
                    expandText = stringResource(R.string.expandable_text_expand_text),
                    collapseText = stringResource(R.string.expandable_text_collapse_text),
                    maxLinesCollapsed = MAX_LINE_COLLAPSED_IN_EXPANDABLE_TEXT_DETAIL_EVENT_SCREEN,
                    style = MaterialTheme.typography.metadata1.copy(color = NeutralWeakColor, lineHeight = 20.sp)
                )
            }

            item {
                VisitorsList(
                    modifier = Modifier.height(HEIGHT_USERS_LIST_DETAIL_EVENT_SCREEN.dp),
                    visitorsList = usersList
                )
            }
        }

        when(stateBnt) {
            ButtonState.PRESSED.id -> AnimatedCustomOutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN.dp),
                label = ButtonState.PRESSED.label,
                onClick = { onClickButton() }
            )
            else -> AnimatedCustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = VERTICAL_PADDING_BUTTON_DETAIL_EVENT_SCREEN.dp),
                label = ButtonState.UNPRESSED.label,
                onClick = { onClickButton() }
            )
        }
    }
}

@Composable
fun FullScreenImageDialog(isMapFullScreen: MutableState<Boolean>) {
    if (isMapFullScreen.value) {
        Dialog(onDismissRequest = { isMapFullScreen.value = false }) {
            var scale by remember { mutableFloatStateOf(1f) }
            var offset by remember { mutableStateOf(Offset.Zero) }

            val width = 1280f
            val height = 720f
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(width / height)
            ) {
                Image(
                    painter = painterResource(R.drawable.defaultmap),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                scale = (scale * zoom).coerceIn(1f, 5f)

                                val maxOffsetX = (scale - 1) * size.width / 2
                                val maxOffsetY = (scale - 1) * size.height / 2

                                offset = Offset(
                                    x = (offset.x + pan.x * scale).coerceIn(
                                        -maxOffsetX,
                                        maxOffsetX
                                    ),
                                    y = (offset.y + pan.y * scale).coerceIn(-maxOffsetY, maxOffsetY)
                                )
                            }
                        }
                )
            }
        }
    }
}

sealed class ButtonState(val id: String, val label: String) {
    data object DEFAULT: ButtonState(id = "default", label = "Пойду на встречу!")
    data object PRESSED: ButtonState(id = "pressed", label = "Схожу в другой раз")
    data object UNPRESSED: ButtonState(id = "unpressed", label = "Пойду на встречу!")
}