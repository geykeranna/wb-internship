package ru.wb.ui.ui.component.cards.visitors

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserItemsData
import ru.wb.ui.ui.component.avatars.UserAvatar
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR_IN_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun UserShortCard(
    userData: UserItemsData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(SIZE_USER_AVATAR_IN_CARD.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        UserAvatar(
            sizeAvatar = AvatarsSize.NORMAL,
            src = userData.icon
        )

        Text(
            text = userData.name,
            style = AppTheme.typography.primary
        )

        TagsChips(
            data = userData.role ?: listOf()
        )
    }
}