package ru.wb.ui.ui.component.chips

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.SocialMedia
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_CHIPS_ITEM_LIST
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_SOCIAL_CHIPS
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.component.utils.Constants.SIZE_OF_ICON_SOCIAL_CHIPS_GROUP
import ru.wb.ui.ui.component.utils.defaultSocialMediaMap
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun SocialChips(
    list: List<SocialMedia>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS_ITEM_LIST.dp),
        contentPadding = PaddingValues(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp),
    ) {
        items(list) { item ->
            val icon = defaultSocialMediaMap.getOrDefault(item.name) { R.drawable.ic_help_circle}
            val context = LocalContext.current
            val intent = remember {
                Intent(Intent.ACTION_VIEW, Uri.parse(item.baseUrl + item.url))
            }

            if (intent.data.toString().isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .size(SIZE_OF_ICON_SOCIAL_CHIPS_GROUP.dp)
                        .clip(RoundedCornerShape(CORNER_RADIUS_OF_SOCIAL_CHIPS.dp))
                        .background(AppTheme.colors.brandColorDefault)
                        .noRippleClickable { context.startActivity(intent) }
                ) {
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(id = icon as Int),
                        contentDescription = item.name,
                        tint = AppTheme.colors.neutralColorBackground
                    )
                }
            }
        }
    }
}