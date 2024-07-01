package ru.testtask.testapplication.ui.component.chips

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.data.modal.SocialMedia
import ru.testtask.testapplication.ui.theme.PurpleDefaultColor

@Composable
fun SocialChips(
    modifier: Modifier = Modifier,
    list: List<SocialMedia>
) {
    LazyRow(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            list.size
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .border(1.67.dp, PurpleDefaultColor, RoundedCornerShape(25.dp))
            ) {
                list[it].icon?.let { icon ->
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 26.dp, vertical = 10.dp)
                            .size(20.dp)
                            .align(Alignment.Center),
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = PurpleDefaultColor
                    )
                }
            }
        }

    }
}