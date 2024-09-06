package ru.wb.ui.ui.screens.community.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.ui.ui.component.avatars.CommunityAvatar
import ru.wb.ui.ui.component.cards.community.CommunitySize
import ru.wb.ui.ui.component.chips.ChipsGroup
import ru.wb.ui.ui.component.chips.ChipsSize
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun DetailCommunityInfo(
    detailInfo: CommunityData,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        CommunityAvatar (
            modifier = Modifier,
            src = detailInfo.icon,
            isVerified = detailInfo.isVerified,
            size = CommunitySize.FULL,
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = detailInfo.label,
            color = AppTheme.colors.neutralColorFont,
            style = AppTheme.typography.heading1
        )

        ChipsGroup(
            data = detailInfo.tags,
            size = ChipsSize.NORMAL,
            onChangeSelect = null
        )
    }
}