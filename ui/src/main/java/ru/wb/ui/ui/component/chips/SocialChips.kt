package ru.wb.ui.ui.component.chips

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import ru.wb.ui.ui.component.utils.Constants.BORDER_WIDTH_OF_SOCIAL_CHIP
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_CHIPS_ITEM_LIST
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_SOCIAL_CHIPS
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_ICON_SOCIAL_CHIPS_GROUP
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_LINE_SOCIAL_CHIPS_GROUP
import ru.wb.ui.ui.theme.BrandDefaultColor

@Composable
internal fun SocialChips(
    list: List<SocialMedia>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .fillMaxSize()
            .height(HEIGHT_OF_LINE_SOCIAL_CHIPS_GROUP.dp),
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_CHIPS_ITEM_LIST.dp)
    ) {
        items(
            list.size
        ) {
            val context = LocalContext.current
            val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(list[it].url)) }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_OF_SOCIAL_CHIPS.dp))
                    .border(BORDER_WIDTH_OF_SOCIAL_CHIP.dp, BrandDefaultColor, RoundedCornerShape(CORNER_RADIUS_OF_SOCIAL_CHIPS.dp))
            ) {
                list[it].icon?.let { icon ->
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 26.dp, vertical = 10.dp)
                            .size(HEIGHT_OF_ICON_SOCIAL_CHIPS_GROUP.dp)
                            .align(Alignment.Center)
                            .clickable { if(intent.data.toString().isNotEmpty()) context.startActivity(intent) },
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = BrandDefaultColor
                    )
                }
            }
        }
    }
}