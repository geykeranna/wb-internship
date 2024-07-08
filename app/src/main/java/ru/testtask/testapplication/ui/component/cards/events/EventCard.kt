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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.avatars.GroupAvatar
import ru.testtask.testapplication.ui.component.chips.CustomChipsGroup
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.bodyText1

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    title: String = "",
    tagList: List<String> = listOf(),
    date: String = "",
    location: String = "",
    onClick: () -> Unit = {},
    src: String? = null,
){
    Column(
        modifier = Modifier
            .height(88.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = modifier
                .height(76.dp)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            GroupAvatar(
                src = src,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .padding(horizontal = 4.dp)
            )
            Column(
                modifier = Modifier
                    .height(76.dp)
                    .fillMaxWidth()
                    .padding(start = 12.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .padding(bottom = 2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        text = title,
                        style = MaterialTheme.typography.bodyText1,
                        color = Color.Black
                    )
                }

                Text(
                    modifier = Modifier
                        .height(20.dp)
                        .padding(bottom = 2.dp),
                    text = "$date — $location",
                    style = MaterialTheme.typography.bodyText1,
                    color = NeutralDisabledColor
                )
                CustomChipsGroup(
                    chipsList = tagList
                )
            }
        }

        HorizontalDivider(
            color = NeutralLineColor,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}