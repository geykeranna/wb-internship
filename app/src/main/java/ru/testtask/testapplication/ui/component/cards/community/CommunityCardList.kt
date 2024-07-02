package ru.testtask.testapplication.ui.component.cards.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.data.model.CommunityData

@Composable
fun CommunityCardList(
    modifier: Modifier = Modifier,
    itemsList: List<CommunityData>,
    onClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.heightIn(min = (itemsList.size * 104).dp, max = (itemsList.size * 104).dp + 10.dp),
        contentPadding = PaddingValues(top = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        items(itemsList.size){index ->
            CommunityCard(
                label = itemsList[index].label,
                onClick = onClick,
                countPeople = itemsList[index].countPeople,
                src = itemsList[index].icon
            )
        }
    }
}