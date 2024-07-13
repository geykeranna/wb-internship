package ru.testtask.testapplication.ui.component.cards.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.ui.component.avatars.GroupAvatar
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_BODY_TEXT_IN_EVENT_CARD
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_EVENT_CARD
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_METADATA_TEXT_IN_EVENT_CARD
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_WITHOUT_DIVIDER_IN_EVENT_CARD
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_AROUND_IMG_IN_EVENT_CARD
import ru.testtask.testapplication.ui.component.utils.Constants.PADDING_START_TEXT_BLOCK_IN_EVENT_CARD
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1

@Composable
fun EventCard(
    eventData: EventData,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    src: String? = null,
){
    Column(
        modifier = Modifier
            .height(HEIGHT_OF_EVENT_CARD.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .height(HEIGHT_WITHOUT_DIVIDER_IN_EVENT_CARD.dp)
                .fillMaxWidth()
        ) {
            GroupAvatar(
                src = src,
                modifier = Modifier
                    .padding(PADDING_AROUND_IMG_IN_EVENT_CARD.dp)
            )
            Column(
                modifier = Modifier
                    .height(76.dp)
                    .fillMaxWidth()
                    .padding(start = PADDING_START_TEXT_BLOCK_IN_EVENT_CARD.dp),
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 2.dp),
                    text = eventData.name,
                    style = MaterialTheme.typography.bodyText1.copy(lineHeight = HEIGHT_OF_BODY_TEXT_IN_EVENT_CARD.sp),
                    color = Color.Black
                )

                Text(
                    modifier = Modifier
                        .padding(bottom = 2.dp),
                    text = "${eventData.date} — ${eventData.location.city}",
                    style = MaterialTheme.typography.metadata1.copy(lineHeight = HEIGHT_OF_METADATA_TEXT_IN_EVENT_CARD.sp),
                    color = NeutralDisabledColor
                )
                CustomChipsGroup(
                    chipsList = eventData.tagList
                )
            }
        }

        HorizontalDivider(
            color = NeutralLineColor,
        )
    }
}

@Preview
@Composable
fun Preview(){
    EventCard(
        eventData = EventData.shimmerData1
    )
}