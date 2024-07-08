package ru.testtask.testapplication.ui.component.cards.community

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.avatars.CommunityAvatar
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.bodyText1
import ru.testtask.testapplication.ui.theme.metadata1
import java.util.Locale

@Composable
fun CommunityCard(
    modifier: Modifier = Modifier,
    src: String? = null,
    onClick: () -> Unit = {},
    label: String = "",
    countPeople: Int = 0
) {
    val countText = String.format(Locale.ENGLISH, "%,d", countPeople).replace(",", " ")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
        ){
            CommunityAvatar(
                modifier = Modifier.padding(4.dp),
                src = src
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .height(24.dp),
                    text = label,
                    style = MaterialTheme.typography.bodyText1
                )
                Text(
                    modifier = Modifier.height(20.dp),
                    text = "$countText человек",
                    style = MaterialTheme.typography.metadata1,
                    color = NeutralDisabledColor
                )
            }
        }

        HorizontalDivider(
            color = NeutralLineColor,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}