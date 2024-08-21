package ru.wb.ui.ui.component.cards.visitors

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.avatars.UserAvatar
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR_IN_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun UserShortCard(
    userData: UserData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(SIZE_USER_AVATAR_IN_CARD.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        UserAvatar(
            size = AvatarsSize.NORMAL
        )

        Text(
            text = userData.firstName,
            style = AppTheme.typography.primary
        )

        TagsChips(
            data = listOf (
                ChipsData(
                    id = "0",
                    name = userData.role ?: ""
                )
            )
        )
    }
}