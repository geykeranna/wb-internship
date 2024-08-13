package ru.wb.ui.ui.component.cards.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.ui.R
import ru.wb.ui.ui.component.avatars.CommunityAvatar
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_BODY_TEXT_IN_COMMUNITY_CARD
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_COMMUNITY_CARD
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_METADATA_TEXT_IN_COMMUNITY_CARD
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_WITHOUT_DIVIDER_IN_COMMUNITY_CARD
import ru.wb.ui.ui.component.utils.Constants.PADDING_AROUND_IMG_IN_COMMUNITY_CARD
import ru.wb.ui.ui.component.utils.Constants.PADDING_START_TEXT_BLOCK_IN_COMMUNITY_CARD
import ru.wb.ui.ui.theme.AppTheme
import java.util.Locale

@Composable
internal fun CommunityCard(
    modifier: Modifier = Modifier,
    src: String? = null,
    label: String = "",
    countPeople: Int = 0,
    onClick: () -> Unit = {},
) {
    val countText = String.format(Locale.ENGLISH, "%,d", countPeople).replace(",", " ")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(HEIGHT_OF_COMMUNITY_CARD.dp)
            .clickable { onClick() },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.height(HEIGHT_WITHOUT_DIVIDER_IN_COMMUNITY_CARD.dp)
        ){
            CommunityAvatar(
                modifier = Modifier.padding(PADDING_AROUND_IMG_IN_COMMUNITY_CARD.dp),
                src = src
            )

            Column(
                modifier = Modifier
                    .padding(start = PADDING_START_TEXT_BLOCK_IN_COMMUNITY_CARD.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 6.dp),
                    text = label,
                    style = AppTheme.typography.bodyText1.copy(
                        lineHeight = HEIGHT_OF_BODY_TEXT_IN_COMMUNITY_CARD.sp
                    )
                )
                Text(
                    modifier = Modifier,
                    text = "$countText ${stringResource(id = R.string.continuation_count_of_human)}",
                    style = AppTheme.typography.metadata1.copy(
                        lineHeight = HEIGHT_OF_METADATA_TEXT_IN_COMMUNITY_CARD.sp),
                    color = AppTheme.colors.neutralColorDisabled
                )
            }
        }

        HorizontalDivider(
            color = AppTheme.colors.neutralColorDivider
        )
    }
}