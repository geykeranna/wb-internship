package ru.wb.ui.ui.component.cards.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.avatars.CommunityAvatar
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsMode
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun CommunityCard(
    modifier: Modifier = Modifier,
    src: String? = null,
    label: String = "",
    tags: List<ChipsData> = listOf(),
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CommunityAvatar(
            src = src,
            size = CommunitySize.FULL
        )

        Text(
            text = label,
            style = AppTheme.typography.communityLabelFull,
            color = AppTheme.colors.neutralColorFont
        )

        ChipsGroup(
            data = tags,
            mode = ChipsMode.NO_SELECT
        )
    }
}