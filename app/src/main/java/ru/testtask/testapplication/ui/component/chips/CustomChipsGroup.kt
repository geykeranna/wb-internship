package ru.testtask.testapplication.ui.component.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.theme.BrandBackgroundColor
import ru.testtask.testapplication.ui.theme.BrandDarkModeColor
import ru.testtask.testapplication.ui.theme.metadata3

@Composable
fun CustomChipsGroup(
    modifier: Modifier = Modifier,
    chipsList: List<String> = listOf(),
) {
    LazyRow(
        modifier = modifier.height(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(chipsList.size) {
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(BrandBackgroundColor)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    text = chipsList[it],
                    maxLines = 1,
                    color = BrandDarkModeColor,
                    style = MaterialTheme.typography.metadata3
                )
            }
        }
    }
}
