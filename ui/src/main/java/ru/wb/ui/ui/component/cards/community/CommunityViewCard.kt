package ru.wb.ui.ui.component.cards.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.ui.R
import ru.wb.ui.ui.component.avatars.CommunityAvatar
import ru.wb.ui.ui.component.utils.Constants.IMG_SIZE_COMMUNITY_AVATAR_SMALL
import ru.wb.ui.ui.theme.AppTheme

@Composable
fun CommunityViewCard(
    communityData: CommunityData,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(IMG_SIZE_COMMUNITY_AVATAR_SMALL.dp)
            .clip(RoundedCornerShape(12.dp))
        ,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CommunityAvatar(
            src = communityData.icon,
            size = CommunitySize.SMALL,
        )
        
        Text(
            text = communityData.label,
            overflow = TextOverflow.Ellipsis,
            style = AppTheme.typography.communityLabel,
            maxLines = 1,
            color = AppTheme.colors.neutralColorFont
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(37.dp)
                .clip(RoundedCornerShape(12.dp)),
            onClick = onAddClick,
            colors = ButtonColors(
                contentColor = AppTheme.colors.brandColorDefault,
                disabledContentColor = AppTheme.colors.brandColorDefault,
                containerColor = AppTheme.colors.brandColorLight,
                disabledContainerColor = AppTheme.colors.neutralColorSecondaryBackground,
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = ""
            )
        }
    }
}