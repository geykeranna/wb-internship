package ru.wb.ui.ui.component.cards.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.cards.visitors.UserShortCard

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun UsersFlowRow(
    dataList: List<UserData>,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        dataList.forEach { user ->
            UserShortCard(userData = user)
        }
    }
}