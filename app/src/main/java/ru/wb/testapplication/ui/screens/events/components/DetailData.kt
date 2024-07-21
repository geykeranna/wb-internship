package ru.wb.testapplication.ui.screens.events.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.testapplication.ui.component.chips.CustomChipsGroup
import ru.wb.testapplication.ui.component.utils.Constants.HEIGHT_INFO_TEXT_CARD_DETAIL_EVENT_SCREEN
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_DETAIL_SCREEN_COMMON
import ru.wb.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_CONTENT_DETAIL_COMMON
import ru.wb.testapplication.ui.component.utils.Constants.VERTICAL_PADDING_ITEMS_COMMON
import ru.wb.testapplication.ui.component.utils.Constants.VERTICAL_SPACE_BY_CONTENT_COMMON
import ru.wb.testapplication.ui.theme.NeutralWeakColor
import ru.wb.testapplication.ui.theme.bodyText1

@Composable
fun DetailData(
    detailInfo: EventData,
    stateBnt: String,
    isMapFullScreen: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {},
) {
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
            onClickButton = onClickButton
        )
    }
}